package com.landon.leetcode;

public class Q862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return 0;
    }
}
