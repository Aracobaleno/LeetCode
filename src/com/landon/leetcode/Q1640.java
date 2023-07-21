package com.landon.leetcode;

import java.util.HashMap;

public class Q1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] hash = new int[101];
        for (int i = 0; i < pieces.length; i++) {
            hash[pieces[i][0]] = i;
        }
        for (int i = 0; i < arr.length;) {
            int[] nums = pieces[hash[arr[i]]];
            for (int j = 0; j < nums.length; j++) {
                if (arr[i] != nums[j]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
    public boolean canFormArray2(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            hash.put(pieces[i][0], i);
        }
        for (int i = 0; i < arr.length;) {
            if (!hash.containsKey(arr[i]))
                return false;
            for (int num : pieces[hash.get(arr[i])]) {
                if (num != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
