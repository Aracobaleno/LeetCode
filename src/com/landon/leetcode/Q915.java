package com.landon.leetcode;

public class Q915 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0 ; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (max <= min[i]) {
                return i;
            }
            max = Math.max(max, nums[i]);
        }
        return 0;
    }

    public int partitionDisjoint2(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0], leftPos = 0, curMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }
}
