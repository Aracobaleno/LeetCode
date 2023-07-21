package com.landon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int p = 0, len = target.length;
        for (int i = 1; i <= n; i++) {
            if (i == target[p]) {
                p++;
                ans.add("Push");
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
            if (p == len)
                break;
        }
        return ans;
    }

    public List<String> buildArray2(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int len = target.length;
        for (int i = 1, j = 0; i <= n && j < len; i++) {
            ans.add("Push");
            if (target[j] != i) ans.add("Pop");
            else j++;
        }
        return ans;
    }

    public List<String> buildArray3(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int prev = 0;
        for (int num : target) {
            for (int i = 0; i < num - prev - 1; i++) {
                ans.add("Push");
                ans.add("Pop");
            }
            ans.add("Push");
            prev = num;
        }
        return ans;
    }
}
