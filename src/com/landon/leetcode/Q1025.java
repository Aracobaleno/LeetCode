package com.landon.leetcode;

public class Q1025 {
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    public boolean divisorGame2(int n) {
        boolean[] f = new boolean[n+1];
        if (n == 1) return false;
        f[1] = false;
        f[2] = true;//没上方判断，在n==1的时候这里下标越界
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
