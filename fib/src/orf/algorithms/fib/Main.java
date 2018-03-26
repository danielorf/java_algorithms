package orf.algorithms.fib;

import java.util.Arrays;

public class Main {

    static int[] fibSequence(int length) {
        int[] fibArray = new int[length];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i < length; ++i) {
            fibArray[i] = fibArray[i-2] + fibArray[i-1];
        }
        return fibArray;
    }

    static int fibVal(int fibIndex) {
        int[] fibSeq = fibSequence(fibIndex);
        return fibSeq[fibIndex-1];
    }

    public static void main(String[] args) {
        int[] fibArray = fibSequence(20);
        System.out.println(Arrays.toString(fibArray));
        System.out.println(fibVal(5));
    }
}
