package com.landon.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Q870 {
    //排序+双指针（贪心）
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(idx, (i, j) -> nums2[i] - nums2[j]);
        int l = 0, r = n - 1;
        for (int i : nums1) {
            if (i > nums2[idx[l]]) nums2[idx[l++]] = i;
            else nums2[idx[r--]] = i;
        }
        return nums2;
    }


    //红黑树+hash表
    public int[] advantageCount2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeSet<Integer> tset = new TreeSet<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums1) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
            if (hash.get(num) == 1) tset.add(num);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Integer cur = tset.ceiling(nums2[i] + 1);
            if (cur == null) cur = tset.ceiling(-1);
            ans[i] = cur;
            hash.put(cur, hash.get(cur) - 1);
            if (hash.get(cur) == 0) tset.remove(cur);
        }
        return ans;
    }
}
