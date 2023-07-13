import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

public class DecipherMissing
{
    List<Integer> mainList = new ArrayList<Integer>();
    List<Integer> subList = new ArrayList<Integer>();
    int averageDiff = 0;

    public static int storeDiffs()
    {
        // Get the average interval between two values.
        MissingPositiveEntry mpe = new MissingPositiveEntry();
        mpe.mpeMethod(List<Integer> mainList);

        for (auto i : mainList)
        {
            int j = i + 1;
            if (mainList.get(i) == 0)
            {
                System.out.printf("ArrayList possesses a value of 0, see: %d%n", i);
                subList.add(mainList.get(i));
            } else if (mainList.get(i) != 0)
            {
                int sub = mainList.get(i) - mainList.get(i + 1);
                System.out.printf("Difference is: %d%n", sub);
                subList.add(sub);
            }
        }

        return subList;
    }

    public static int averageDiffs(List<Integer> subList)
    {
        int total = 0;

        for (auto j : subList)
        {
            total++;
            int addEmUP;
            addEmUP += subList.get(j);
            averageDiff = addEmUP/total;
        }

        return averageDiff;
    }

    public static int generateMissing(int averageDiff)
    {
        try
        {
            for (auto k : mainList)
            {
                if (k != mainList.size() - 1) // As long as we haven't reached the end, continue.
                {
                    int tempDiff = mainList.get(k) - (mainList.get(k + 1)); // Store the diff between values.

                    if (tempDiff > averageDiff) // If that diff proves greater than the average, continue.
                    {
                        if (tempDiff < 0)
                        {
                            mainList.add(tempDiff - mainList.get(k)); // Add a new int short of the current by the tempDiff value.
                        } else
                        {
                            String failed = "mainList cannot contain negative values.";
                            System.out.printf("%s%n", failed);
                            return generateMissing(averageDiff);
                        }
                    } else if (tempDiff < averageDiff) // Handle the case when it proves less than average.
                    {
                        mainList.add(tempDiff + mainList.get(k));
                    } else if (!mainList.contains(0))
                    {
                        mainList.add(0); // Handle the case where 0 needs to be added.
                    }
                }

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
