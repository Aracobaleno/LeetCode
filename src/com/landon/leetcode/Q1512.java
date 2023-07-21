package com.landon.leetcode;

public class Q1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] hash = new int[101];
        int ans = 0;
        for (int num : nums) {
            ans += hash[num];
            ++hash[num];
        }
        return ans;
    }
}
