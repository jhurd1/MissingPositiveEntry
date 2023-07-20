import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Integer;

public class DecipherMissing
{
    // DATA MEMBERS
    List<Integer> subList = new ArrayList<Integer>();

    int averageDiff = 0;
    int temp = 0;
    int total = 0;
    int lvalue = 0;
    int lastTempValue = 0;
    int next = 0;

    // ACCESSORS

    public List<Integer> getSubList()
    {
        return subList;
    }

    /*
    GETNEXT
    Helps AverageDiffs find
    the average difference
    between each element
    by handing it the next element
    in the sorted arrayList.
     */
    public int getNext(int nextInt, List<Integer> subList)
    {
        if (nextInt < 0 || nextInt + 1 == subList.size())
        {
            return 0;
        }
        return subList.get(nextInt + 1);
    }

    // MUTATORS

    /*
    SETTEMP
    prevents the duplicate
    of similar logic
    in averageDiffs and
    generateMissing.
     */
    public int setTemp(int lvalue, List<Integer> subList)
    {
        next = getNext(lvalue, subList);
        if ((next > subList.get(lvalue)) && (next != 0))
        {
            temp = next - subList.get(lvalue);
            lastTempValue = temp;
        } else if ((next < subList.get(lvalue)) && (next != 0))
        {
            temp = subList.get(lvalue) - next;
            lastTempValue = temp;
        } else
        {
            temp = lastTempValue;
        }
        System.out.printf("temp: %d%n", temp);
        return temp;
    }

    /*
    AVERAGEDIFFS
    Gleans the average difference
    between each element to help
    prepare for adding missing elements
    between the lowest value one and 0.
     */
    public int averageDiffs(List<Integer> subList)
    {
        int sum = 0;
        for (int j = 0; j < subList.size(); ++j)
        {
            total++;
            //lvalue = subList.get(j);
            lvalue = j;
            setTemp(lvalue, subList);
            sum += lastTempValue;
        }
        averageDiff = sum/total;
        System.out.printf("averageDiff: %d%n", averageDiff);
        generateMissing(averageDiff, subList);
        return averageDiff;
    }

    /*
    GENERATEMISSING
    generates the missing elements
    back to 0, finalizing the
    original intent of this program.
     */
    public int generateMissing(int averageDiff, List<Integer> subList)
    {
        try
        {
            for (int k = 0; k < subList.size(); ++k)
            {
                if (k != subList.size() - 1) // As long as we haven't reached the end, continue.
                {
                    int tempDiff = setTemp(k, subList);

                    System.out.printf("Difference between lvalue and rvalue: %d%n", tempDiff);
                    if (tempDiff > averageDiff) // If that diff proves greater than the average, continue.
                    {
                        if (tempDiff < 0)
                        {
                            subList.add(tempDiff - subList.get(k)); // Add a new int short of the current by the tempDiff value.
                        } else
                        {
                            String failed = "This collection cannot contain negative values. Trying again.";
                            System.out.printf("%s%n", failed);
                            return generateMissing(averageDiff, subList);
                        }
                    } else if (tempDiff < averageDiff) // Handle the case when it proves less than average.
                    {
                        subList.add(tempDiff + subList.get(k));
                    } else if (!subList.contains(0))
                    {
                        subList.add(0); // Handle the case where 0 needs to be added.
                        int i = 0; // Return to index 0.
                        int m = subList.get(i) - 0; // Total difference from 0 to lowest.
                        int n = (m/averageDiff) - 1; // Divide this the averageDiff to get how many figures to enter; missing numbers.
                        // Subtracting one should furnish the corrrect # of missing integers.
                        int newDiff = 1;
                        if (n >= 1) // Stop if n comprises a 0 or less.
                        {
                            while (n != 0 && newDiff != 0) // Stop when n becomes 0.
                            {
                                n--; // Keep count.
                                newDiff = subList.get(i) - tempDiff;
                                subList.add(newDiff); // This adds the same thing each time. It shouldn't.
                                tempDiff = newDiff;
                            }
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            String error = "Generating missing integers reached failure.";
            System.out.printf("%s%n", error);
            return 0;
        }
        MissingPositiveEntry mpe = new MissingPositiveEntry();
        //mpe.mpeMethod(subList);
        for (int l : subList)
        {
            System.out.printf("The new list contains: %d%n", l);
        }
        return 0;
    }

}
