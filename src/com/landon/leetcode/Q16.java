package com.landon.leetcode;

import java.util.Arrays;

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] +nums[k];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(closestNum - target))
                    closestNum = sum;
                if (sum > target) {
                    --k;
                    while (j < k && nums[k] == nums[k + 1]) --k;
                } else if (sum < target) {
                    ++j;
                    while (j < k && nums[j] == nums[j - 1]) ++j;
                }
            }
        }
        return closestNum;
    }
}
