
/*
Find the smallest positive integer
not present in an array. Hint:
Find the largest integer first.
 */

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class MissingPositiveEntry
{

    /*
    MPEMETHOD
    sorts the collection
    preparatory to
    determining the average
    difference between each element,
    which proves necessary for inserting
    missing elements back to 0.
     */
    public List<Integer> mpeMethod(List<Integer> A)
    {
        A.add(20);
        A.add(40);
        A.add(30);
        A.add(60);
        A.add(50);

        int count = 0;

        for (int i = 0; i < A.size(); ++i)
        {
            for (int j = 0; j < A.size(); ++j)
            {
                count++;
                System.out.printf("The value for i constitutes: %d%n%n", A.get(i));
                System.out.printf("The value for j constitutes: %d%n%n", A.get(j));
                System.out.printf("Comparisons: %d%n%n", count);

                if (A.get(i) < A.get(j))
                {

                    Integer e = A.get(j);
                    A.set(j, A.get(i));

                    A.set(i, e);
                }
            }
        }

        for (int i : A)
        {
            System.out.printf("Sorted values: %d%n", i);
        }

        DecipherMissing dm = new DecipherMissing();
        dm.averageDiffs(A);

        return A;
    }
}
