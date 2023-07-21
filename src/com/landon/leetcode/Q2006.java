package com.landon.leetcode;

public class Q2006 {
    public int countKDifference(int[] nums, int k) {
        int[] hash = new int[101];
        int ans = 0;
        for (int j = 0; j < nums.length; j++) {
            int x = nums[j] + k;
            if (x>=1 && x <=100) {
                ans += hash[x];
            }
            x = nums[j] - k;
            if (x >=1 && x <= 100) {
                ans += hash[x];
            }
            ++hash[ nums[j] ];
        }
        return ans;
    }
}
