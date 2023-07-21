package com.landon.leetcode;

public class Q1175 {
    static final int Mod = 1000000007;
    public static int numPrimeArrangements(int n) {
        int countPrime = 0;
        int countComposite;
        out: for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) continue out;
            }
            ++countPrime;
        }
        countComposite = n - countPrime;
        return (int) (factorial(countPrime) * factorial(countComposite) % (int) (1e9 + 7));
    }

    public static long factorial(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
            ans %= (int) (1e9 + 7);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(100));
    }
}
