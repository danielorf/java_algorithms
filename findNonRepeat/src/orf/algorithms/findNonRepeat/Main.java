package orf.algorithms.findNonRepeat;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int getNonRepeatBit(int[] array) {
        int total = 0;
        for (int val : array) {
            total ^= val;
        }
        return total;
    }

    static int getNonRepeatDict(int[] array) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int val : array) {
            if (map.get(val) == null) {
                map.put(val, 1);
            } else {
                map.put(val, map.get(val) + 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        return -1;
    }


    public static void main(String[] args) {
        int individualListLength = 100;
        Integer[] array = new Integer[individualListLength * 2 - 1];
        for (int i = 0; i < individualListLength; i++) {
            array[i] = i;
        }

        Random ranIndex = new Random();
        int missingIndex = ranIndex.nextInt(individualListLength);
        int currIndex = individualListLength;
        for (int j = 0; j < individualListLength; j++) {
            if (j == missingIndex) continue;
            array[currIndex] = j;
            currIndex++;
        }

        System.out.println("Missing index: " + missingIndex);
//        System.out.println(array.toString());
        Collections.shuffle(Arrays.asList(array));
        int[] intArray = Arrays.stream(array).mapToInt(Integer::intValue).toArray();

        System.out.println("Array: " + Arrays.toString(intArray));

        System.out.println("Bitwise solution: " + getNonRepeatBit(intArray));

//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        map.put(4, 1);
//        System.out.println(map.get(4));
//        map.put(4, map.get(4) + 1);
//        System.out.println(map.get(4));

        System.out.println("Dict solution: " + getNonRepeatDict(intArray));

//        System.out.println("Array sum = " + Arrays.stream(intArray).sum());

//        System.out.println("---------------------------------");
//
        int[] a = {1, 2, 3, 4, 5, 6, 8, 9};
        int a_min = Arrays.stream(a).min().getAsInt();
        int a_max = Arrays.stream(a).max().getAsInt();
        int[] b = new int[a_max - a_min + 1];
        for (int i = a_min; i < (a_min + b.length); ++i){
            b[i-a_min] = i;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        Set<Integer> a_set = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Set<Integer> b_set = Arrays.stream(b).boxed().collect(Collectors.toSet());

        boolean removeResult = b_set.removeAll(a_set);
        int[] resultArray = b_set.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(resultArray));

//        Set<Integer> =

//        System.out.println(a^b);

//        Integer[] c = {1, 2, 3, 4, 5, 4, 3, 2, 1};
//        System.out.println(Arrays.toString(c));
//        Set<Integer> intSet = new HashSet<Integer>(Arrays.asList(c));
////        Integer[] c_array =  intSet.toArray();
//        int[] c_array = intSet.stream().mapToInt(Integer::intValue).toArray();
//        System.out.println(Arrays.toString(c_array));
////        System.out.println((int) c_array[0]);


    }
}
