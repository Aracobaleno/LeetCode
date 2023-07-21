package com.landon.leetcode;

import java.util.Arrays;

public class Q324 {
    //超时的BubbleSort
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                    flag = true;
                }
            }
            if (flag = false)
                break;
        }
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

    //Arrays.sort快排
    public void wiggleSort1(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
    }
}
