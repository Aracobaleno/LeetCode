package com.landon.leetcode;

public class Q801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = 0; int b = 1;
        for (int i = 1; i < n; i++) {
            int pre_a = a, pre_b = b;
            a = n; b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                a = pre_a;
                b = pre_b + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, pre_b);
                b = Math.min(b, pre_a + 1);
            }
        }
        return Math.min(a, b);
    }
}
