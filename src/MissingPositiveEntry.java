
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
        A.add(2);
        A.add(4);
        A.add(3);
        A.add(6);
        A.add(5);

        for (int i = 0; i < A.size(); ++i)
        {
            // Consider the case for int "2" where no duplicates exist in the collection.
            // 0 is less than 2; 2 is less than or equal to the list's size; the last element
            // does not equal the 2 in question.
            while (0 < A.get(i) && A.get(i) <= A.size() && !A.get(A.get(i) - 1).equals(A.get(i)))
            {
                // Therefore, the program swaps 2 with the last element, 5.
                Collections.swap(A, i, A.get(i) - 1);
                System.out.printf("An integer %d%n",  A.get(i));
            }
        }
        // IntStream performs computations on series of integers.
        // range() returns a sequential, ordered IntStream by an increment of one.
        // Start at 0, exclude the beginning, and if not, find the first.

        return IntStream.range(0, A.size()).filter(i -> A.get(i) != i + 1).findFirst().orElse(A.size()) + 1;
    }

}