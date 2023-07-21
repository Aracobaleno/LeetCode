package com.landon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int minAbs = Integer.MAX_VALUE;
        for (int i = n - 1; i > 0; i--) {
            minAbs = Math.min(minAbs, arr[i] - arr[i - 1]);
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] == minAbs){
                ans.add(new ArrayList<>(Arrays.asList(arr[i-1], arr[i])));
            }
        }
        return ans;
    }

    public List<List<Integer>> minimumAbsDifference1(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int minAbs = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            if (arr[i + 1] - arr[i] == minAbs)
                ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
            else if (arr[i + 1] - arr[i] < minAbs){
                ans.clear();
                ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
                minAbs = arr[i + 1] - arr[i];
            }
        }
        return ans;
    }

    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int minAbs = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < minAbs){
                minAbs = diff;
                ans.clear();
            }
            if (diff == minAbs)
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
        }
        return ans;
    }
}
