
/*
Find the smallest positive integer
not present in an array. Hint:
Find the largest integer first.
 */

public class MissingPositiveEntry
{
    int arr[] = {2,4,3,5,6};
    int n = arr.length;
    int arr2[] = new int[n];
    int max = arr[n - 1];

    // Testing git.

    public void mpeMethod()
    {
        for (int i = 0; i < arr.length; ++i)
        {
            for (int j = 0; j < arr.length; ++j)
            {
                System.out.printf("Array's values: %d%n", arr[i]);

                if (arr[i] < arr[j])
                {
                    System.out.printf("Missing value %d%n", arr[i + 1]);
                }
            }
        }
    }

}