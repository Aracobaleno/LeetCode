package com.landon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> hash = new HashMap<>();
        int n = nums1.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hash.put(nums1[i] + nums2[j], hash.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                ans += hash.getOrDefault(-(nums3[k] + nums4[l]), 0);
            }
        }
        return ans;
    }
}