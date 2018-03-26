package orf.algorithms.findMissingNum;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    // From geeksforgeeks site (fill in link later)
    static int getMissingNo(int a[], int n) {
        int x1 = a[0];
        int x2 = 1;

		/* For xor of all the elements
		in array */
        for (int i = 1; i < n; i++)
            x1 = x1 ^ a[i];

		/* For xor of all the elements
		from 1 to n+1 */
        for (int i = 2; i <= n + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);
    }

    static int[] getMissingNumSet(int[] array) {

        int arrayMin = Arrays.stream(array).min().getAsInt();
        int arrayMax = Arrays.stream(array).max().getAsInt();
        int[] completeArray = new int[arrayMax - arrayMin + 1];
        for (int i = arrayMin; i < (arrayMin + completeArray.length); ++i) {
            completeArray[i - arrayMin] = i;
        }
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(completeArray));

        Set<Integer> incompleteSet = Arrays.stream(array).boxed().collect(Collectors.toSet());
        Set<Integer> completeSet = Arrays.stream(completeArray).boxed().collect(Collectors.toSet());

        boolean removeResult = completeSet.removeAll(incompleteSet);
        int[] resultArray = completeSet.stream().mapToInt(Integer::intValue).toArray();
//        System.out.println(Arrays.toString(resultArray));

        return resultArray;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 9};
        int miss = getMissingNo(a, 5);
        System.out.println(miss);
        System.out.println(Arrays.toString(getMissingNumSet(a)));
    }
}
