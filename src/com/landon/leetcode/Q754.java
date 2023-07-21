package com.landon.leetcode;

public class Q754 {
    public int reachNumber(int target) {
        int t = Math.abs(target);
        int sum = 0, k = 0;
        while (sum < t) {
            k++;
            sum += k;
        }
        return ((sum - t) & 1) != 1 ? k : k + 1 + k % 2;
    }
}
