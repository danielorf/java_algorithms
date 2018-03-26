package orf.algorithms.primes;

import java.security.cert.TrustAnchor;

public class Main {

    static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        } else if (num == 2) {
            return true;
        }
        for (int i = 2; i<(int)Math.ceil(Math.sqrt(num))+1; i++) {
            if (num % i ==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isPrime(2));
        for (int i =0; i < 20; i++) {
            System.out.println(i + " " + isPrime(i));
        }
    }
}
