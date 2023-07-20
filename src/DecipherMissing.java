import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Integer;

public class DecipherMissing
{
    List<Integer> subList = new ArrayList<Integer>();

    int averageDiff = 0;
    int temp = 0;
    int total = 0;
    int lvalue = 0;
    int lastTempValue = 0;
    int next = 0;

    public int getAverageDiff()
    {
        return averageDiff;
    }

    public int getTemp()
    {
        return temp;
    }

    public int getTotal()
    {
        return total;
    }

    public int getLvalue()
    {
        return lvalue;
    }

    public int getLastTempValue()
    {
        return lastTempValue;
    }

    public int getNext()
    {
        return next;
    }

    public void setAverageDiff(int averageDiff)
    {
        this.averageDiff = averageDiff;
    }

    public void setTemp(int temp)
    {
        this.temp = temp;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public void setLvalue(int lvalue)
    {
        this.lvalue = lvalue;
    }

    public void setLastTempValue(int lastTempValue)
    {
        this.lastTempValue = lastTempValue;
    }

    public void setNext(int next)
    {
        this.next = next;
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

    /*
    SETTEMP
    prevents the duplicate
    of similar logic
    in averageDiffs and
    generateMissing.
     */
    public int setTemp(int temp, int lvalue)
    {
        if ((getNext() > lvalue) && (getNext() != 0))
        {
            temp = next - lvalue;
            lastTempValue = temp;
        } else if ((next < lvalue) && (next != 0))
        {
            temp = lvalue - next;
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
            lvalue = subList.get(j);
            //next = getNext(j, subList);
            setNext(getNext(j, subList));
            setTemp(temp, lvalue);
            //lastTempValue = temp;
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
    back to 0, finalizing this
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
                    //int tempDiff = subList.get(k) - (subList.get(k + 1)); // Store the diff between values.
                    int tempDiff = setTemp(k, subList.get(k));
                    // call setTemp()

                    System.out.printf("Difference between lvalue and rvalue: %d%n", tempDiff);
                    if (tempDiff > averageDiff) // If that diff proves greater than the average, continue.
                    {
                        if (tempDiff < 0)
                        {
                            subList.add(tempDiff - subList.get(k)); // Add a new int short of the current by the tempDiff value.
                        } else
                        {
                            String failed = "mainList cannot contain negative values.";
                            System.out.printf("%s%n", failed);
                            return generateMissing(averageDiff, subList);
                        }
                    } else if (tempDiff < averageDiff) // Handle the case when it proves less than average.
                    {
                        subList.add(tempDiff + subList.get(k));
                    } else if (!subList.contains(0))
                    {
                        subList.add(0); // Handle the case where 0 needs to be added.
                    }
                }
            }
            for (int l : subList)
            {
                System.out.printf("The new list contains: %d%n", l);
            }
        } catch (Exception e)
        {
            String error = "Generating missing integers reached failure.";
            System.out.printf("%s%n", error);
            return 0;
        }
        return 0;
    }

}
