package com.landon.leetcode;

public class Q7 {
    public int reverse(int x) {
        int ans = 0, preStep = 0;
        if (x == 0) return 0;
        while (x != 0) {
            ans = ans * 10 +  x % 10;
            if (ans /10 != preStep) {
                return 0;
            }
            x = x / 10;
            preStep = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
