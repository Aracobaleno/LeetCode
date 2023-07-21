package com.landon.leetcode;

public class Q1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] hash = new boolean[26];
        for (char c : allowed.toCharArray()) {
            hash[c - 'a'] = true;
        }
        int ans = 0;
        out: for (String s : words) {
            for (char c : s.toCharArray()) {
                if (!hash[c - 'a']) continue out;
            }
            ans++;
        }
        return ans;
    }

    public int countConsistentStrings2(String allowed, String[] words) {
        boolean[] hash = new boolean[26];
        for (char c : allowed.toCharArray()) {
            hash[c - 'a'] = true;
        }
        int ans = 0;
        for (String s : words) {
            if (check(s, hash)) ans++;
        }
        return ans;
    }

    private boolean check(String s, boolean[] allowed) {
        for (char c : s.toCharArray()) {
            if (!allowed[c - 'a']) return false;
        }
        return true;
    }

    public int countConsistentStrings3(String allowed, String[] words) {
        int mark = 0;
        for (char c : allowed.toCharArray()) {
            mark |= 1 << (c - 'a');
        }
        int ans = 0;
        for (String s : words) {
            int mark1 = 0;
            for (char c : s.toCharArray()) {
                mark1 |= 1 << (c - 'a');
            }
            if ((mark | mark1) == mark) ans++;
        }
        return ans;
    }
}
