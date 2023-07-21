package com.landon.leetcode;

public class Q1800 {
    public int maxAscendingSum(int[] nums) {
        int ans = 0, max = 0;
        int n = nums.length;
        max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                max += nums[i];
            } else {
                ans = Math.max(ans, max);
                max = nums[i];
            }
        }
        ans = Math.max(ans, max);
        return ans;
    }
}