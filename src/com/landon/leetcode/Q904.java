package com.landon.leetcode;

import java.util.HashMap;

public class Q904 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] cnt = new int[n];
        int left = 0, ans = 0;
        for (int right = 0, total = 0; right < n; right++) {
            if (++cnt[fruits[right]] == 1)
                total++;
            while (total > 2) {
                if (--cnt[fruits[left++]] == 0)
                    total--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int totalFruit2(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int left = 0, ans = 0;
        for (int right = 0; right < n; right++) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
