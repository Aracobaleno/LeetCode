package com.landon.leetcode;

import java.util.ArrayList;
import java.util.List;

;
public class Q1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] hash = new int[100];
        int len = s1.length();
        int count = 0;
        int pm = 0;
        char a = 'a', b = 'a';
        for (int i = 0; i < len; i++) {
            hash[i] = s1.charAt(i) - s2.charAt(i);
            if (hash[i] != 0) {
                count++;
                pm += hash[i];
                if (count == 2) {
                    if (a != s2.charAt(i) || b != s1.charAt(i)) {
                        return false;
                    }
                }
                a = s1.charAt(i);
                b = s2.charAt(i);
            }
        }
        if (count > 2 || count == 1) {
            return false;
        }
        return true;
    }

    public boolean areAlmostEqual2(String s1, String s2) {
        int len = s1.length();
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff.size() >= 2) {
                    return false;
                }
                diff.add(i);
            }
        }
        if (diff.isEmpty()) {
            return true;
        }
        if (diff.size() != 2) {
            return false;
        }
        return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) && s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
    }

    public boolean areAlmostEqual3(String s1, String s2) {
        int len = s1.length(), a = -1, b = -1;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            if (a == -1) a = i;
            else if (b == -1) b = i;
            else return false;
        }
        if (a == -1) return true;
        if (b == -1) return false;
        return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
    }

    public boolean areAlmostEqual4(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        char char1 = '1';
        char char2 = '1';
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count >= 2) return false;
                if (char1 == '1') {
                    char1 = s1.charAt(i);
                    char2 = s2.charAt(i);
                } else {
                    if (s2.charAt(i) != char1 || s1.charAt(i) != char2) return false;
                }
                count++;
            }
        }
        return count != 1;
    }
}
