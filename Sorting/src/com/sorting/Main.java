package com.sorting;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int[] quickSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int pivotIndex = array.length / 2;
        int pivotVal = array[pivotIndex];
        int leftCount = 0;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] < pivotVal) ++leftCount;
        }

        int[] left = new int[leftCount];
        int[] right = new int[array.length - leftCount - 1];

        int l_index = 0;
        int r_index = 0;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] == pivotVal) continue;
            if (array[i] < pivotVal) {
                left[l_index] = array[i];
                l_index++;
            } else {
                right[r_index] = array[i];
                r_index++;
            }
        }

        left = quickSort(left);
        right = quickSort(right);

        System.arraycopy(left, 0, array, 0, left.length);
        array[left.length] = pivotVal;
        System.arraycopy(right, 0, array, left.length + 1, right.length);

        return array;
    }

    static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);

    }

    static int[] merge(int[] a, int[] b) {
        int a_index = 0;
        int b_index = 0;
        int result_index = 0;

        int[] result = new int[a.length + b.length];

        while (a_index < a.length && b_index < b.length) {
            if (a[a_index] < b[b_index]) {
                result[result_index] = a[a_index];
                a_index++;
                result_index++;
            } else {
                result[result_index] = b[b_index];
                b_index++;
                result_index++;
            }
        }
        while (a_index < a.length) {
            result[result_index] = a[a_index];
            a_index++;
            result_index++;
        }
        while (b_index < b.length) {
            result[result_index] = b[b_index];
            b_index++;
            result_index++;
        }
        return result;
    }

    static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];

            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] array = new int[] {1,2,3,4,5};
        Integer[] array = new Integer[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 5;
        }

        Collections.shuffle(Arrays.asList(array));

//        System.out.println(Arrays.toString(array));
        int[] intArray = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
        int[] quickSorted = quickSort(intArray);
        System.out.println(Arrays.toString(quickSorted));
        System.out.println(Arrays.toString(mergeSort(intArray)));

//        System.out.println(mergeSort(intArray)[0]);
        System.out.println(binarySearch(quickSorted, 14));
    }
}
