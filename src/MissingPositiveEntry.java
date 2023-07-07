
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

        int count = 0; // The number of possible comparisons, which I think should be 25 (5 x 5).
        // I should only need to make four comparisons, not 25.
        // Is it possible to hold one number in memory for a comparison?
        // Think on this for enhancing efficiency later.

        // Insertion sort.
        for (int i = 0; i < A.size() ; ++i) // i represents the initial element for comparison
        {
            for (int j = 0; j < A.size(); ++j)
            {
                count++;
                System.out.printf("The value for i constitutes: %d%n%n", A.get(i));
                System.out.printf("The value for j constitutes: %d%n%n", A.get(j)); // Prints the value, not the index
                System.out.printf("Comparisons: %d%n%n", count);

                if (A.get(i) < A.get(j)) // This compares the values, not the indices.
                {

                    Integer e = A.get(j); // Proves necessary probably for overcoming "cannot dereference" thrown on primitives.
                    //A.set(i,A.get(j)); // Example: 40 swaps with 30, leaving 20, 30, 40 as the orderof 0,1,2.
                    //A.set(temp,A.get(i)); // Keeps from setting all to the lowest value. Temp holds 40.
                    A.set(j,A.get(i)); // Previous element swaps to lower value to put it in order. i becomes 30.
                    //A.set(temp,A.get(j)); // Swaps higher value back into slot 2. 30 becomes 40.

                    //A.set(j,e);
                    A.set(i,e);
                    //A.set(e,i); // Throws exception.
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