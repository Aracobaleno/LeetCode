package com.landon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18 {
    // O(n^4)遍历
    /*public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i -1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j -1])
                    continue;
                for (int k = j + 1; k < n; k++) {
                    if (k > j + 1 && nums[k] == nums[k -1])
                        continue;
                    for (int l = k + 1; l < n; l++) {
                        if (l > k + 1 && nums[l] == nums[l -1])
                            continue;
                        long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            ret.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }
        return ret;
    }*/

    //确定前两个数，双指针找后两个数
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        if (n < 4) return ret;

        long sum4 = (long) nums[0] + nums[1] + nums[2] + nums[3];
        long max3 = (long) nums[n - 3] + nums[n -2] + nums[n - 1];
        long sum3 = 0;
        long max2 = (long) nums[n - 2] + nums[n - 1];
        for (int i = 0; i < n - 3; i++) {
            if (sum4 > target) break;
            if (i + 4 < n) sum4 = sum4 - nums[i] + nums[i + 4];

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            if (nums[i] + max3 < target) continue;

            sum3 = (long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            for (int j = i + 1; j < n - 2; j++) {
                if (sum3 > target) break;
                if (j + 3 < n) sum3 = sum3 - nums[j] + nums[j + 3];

                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                long val = target - nums[i] - nums[j];
                if (max2 < val) continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target)
                        l--;
                    else if (sum < target)
                        k++;
                    else {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }
        return ret;
    }
}
