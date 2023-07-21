package com.landon.leetcode.offer;

public class Q10 {
    public int fib(int n) {
        int a = 0, b = 1, c, mod = 1000000007;
        for (int i = 0; i < n; i++) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return a;
    }
}
