package com.landon.leetcode;

public class Q31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i < 0) {
            reverse(nums, 0);
            return;
        }
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j])
            j--;
        swap(nums, i, j);
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int begin) {
        int end = nums.length - 1;
        while (begin < end) {
            swap(nums, begin, end);
            begin++;
            end--;
        }
    }
    public void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
