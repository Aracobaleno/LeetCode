package com.landon.leetcode;

import java.util.Arrays;

public class Q940 {
    public int distinctSubseqII(String s) {
        final int mod = (int) 1e9 + 7;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int n = s.length();
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (last[j] != -1) {
                    f[i] = (f[i] + f[last[j]]) % mod;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (last[i] != -1) {
                ans = (ans + f[last[i]]) % mod;
            }
        }
        return ans;
    }
}
