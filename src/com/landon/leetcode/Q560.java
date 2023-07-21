package com.landon.leetcode;

import java.util.HashMap;

public class Q560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        hash.put(k,1);
        for (int num : nums) {
            ans += hash.getOrDefault(num, 0);
            hash.put(num + k, hash.getOrDefault(num + k, 0) + 1);
        }
        return ans;
    }
}
