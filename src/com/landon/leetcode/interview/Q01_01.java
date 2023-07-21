package com.landon.leetcode.interview;

public class Q01_01 {
    public boolean isUnique(String astr) {
        int[] hash = new int[26];
        for (char c : astr.toCharArray()) {
            hash[c - 'a']++;
            if (hash[c - 'a'] > 1)
                return false;
        }
        return true;
    }
    public boolean isUnique2(String astr) {
        int bitset = 0;
        for (int i = 0; i < astr.length(); i++) {
            int move = astr.charAt(i) - 'a';
            if ((bitset & (1 << move)) != 0)
                return false;
            else
                bitset |= (1 << move);
        }
        return true;
    }
}
