package com.kodilla.good.patterns.challegnes;

public class Factorial {
    public static void main(String[] args) {
        int n=2;
        long resoult = calculateFactorial(n);
    }

    public static long calculateFactorial(int n) {
        if(n<0) {
            throw new IllegalArgumentException("The number must be non-negative");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        long factorial =1;
        for (int i=2; i<=n; i++) {
            factorial *=i;
        }

        return factorial;
    }
}
