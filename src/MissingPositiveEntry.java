
/*
Find the smallest positive integer
not present in an array. Hint:
Find the largest integer first.
 */

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MissingPositiveEntry
{
    // Testing git.

    public static int mpeMethod(List<Integer> A)
    {
        // size() vs. length()
        // length() entails a constant value
        // size() can change.
        A.add(20);
        A.add(40);
        A.add(30);
        A.add(60);
        A.add(50);

        int temp = 0;

        int sizeOf = A.size();

        int pivot = sizeOf / 2;

        // Insertion sort.
        for (int i = 0; i < A.size() ; ++i) // i represents the initial element for comparison
        {
            for (int j = 0; j < A.size(); ++j)
            {
                if (A.get(i) > A.get(j)) // This compares the values, not the indices.
                {
                    System.out.printf("J is: %d%n", j); // Probably prints the index, not the value
                    System.out.printf("The value for j constitutes: %d%n", A.get(j)); // Prints the value, not the index
                    Integer e = A.get(j);
                    A.set(i,A.get(j));
                    A.set(j,e);
                }
            }
        }

        for (int i : A)
        {
            System.out.printf("Sorted values: %d%n", i);
        }
        return 0;
    }


        /*for (int i = 0; i < A.size(); ++i)
        {
            System.out.printf("The list's elements: %d%n", A.get(i));

            while (0 < A.get(i) && A.get(i) <= A.size() && !A.get(A.get(i) - 1).equals(A.get(i)))
            {
                // Therefore, the program swaps 2 with the last element, 5.
                Collections.swap(A, i, A.get(i) - 1);
                System.out.printf("An integer %d%n",  A.get(i));
            }
        }

        return IntStream.range(0, A.size()).filter(i -> A.get(i) != i + 1).findFirst().orElse(A.size()) + 1;*/


}