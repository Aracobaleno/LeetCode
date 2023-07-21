package com.landon.leetcode.interview;

public class Q16_07 {
    public int maximum(int a, int b) {
        long a1 = a, b1 = b;
        return (int)((a1 + b1) / 2 + Math.abs(a1 - (a1 + b1) / 2));
    }

    public int maxinum2(int a, int b) {
        try {
            Integer integer = a - b;
            int i = (int)integer.toString().charAt(0);
        } catch (Exception e) {
            return b; //两个负数的时候出错
        }
        return a;
    }

    public int maxinum3(int a, int b) {
        long a1 = a, b1 = b;
        int diff = (int) ((a1 - b1) >> 63);
        return (1 + diff) * a - diff * b;
    }
}
