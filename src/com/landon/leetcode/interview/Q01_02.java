package com.landon.leetcode.interview;

import java.util.Arrays;
import java.util.HashMap;

public class Q01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            hash.put(c, hash.getOrDefault(c,0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            hash.put(c, hash.getOrDefault(c, 0) - 1);
            if (hash.getOrDefault(c, 0) == -1)
                return false;
        }
        /*for (int i = 0; i < 52; i++) {
            char c = (char) ('A' + i);
            if (hash.getOrDefault(c, 0) != 0) return false;
        }*/
        return true;
    }

    public boolean CheckPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
