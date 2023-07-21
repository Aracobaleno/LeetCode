package com.landon.leetcode;

public class Q1822 {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) ans = -ans;
        }
        return ans;
    }
}
