package com.landon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        if (len < 3 || nums[0] > 0 || nums[len - 1] < 0)
            return ret;

        if (nums[0] == 0 && nums[len - 1] == 0) {
            ret.add(Arrays.asList(0, 0, 0));
            return ret;
        }

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }

            int j = i + 1;
            int k = len -1;
            while (j < k) {
                int target = nums[i] + nums[j] + nums[k];
                if (target > 0) {
                    k--;
                } else if (target < 0) {
                    j++;
                }else {
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ret;
    }
}
