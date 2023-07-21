package com.landon.leetcode;

public class Q1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder[] strs = new StringBuilder[2];
        strs[0] = new StringBuilder();
        strs[1] = new StringBuilder();
        for (String s : word1) {
            strs[0].append(s);
        }
        for (String s : word2) {
            strs[1].append(s);
        }
        return strs[0].toString().equals(strs[1].toString());
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        int m = word1.length, n = word2.length, p0 = 0, p1 = 0, i = 0, j = 0;
        while (p0 < m && p1 <n) {
            if (word1[p0].charAt(i) != word2[p1].charAt(j)) return false;
            i++; j++;
            if (i == word1[p0].length()) {p0++; i = 0;}
            if (j == word2[p1].length()) {p1++; j = 0;}
        }
        return p0 == m && p1 == n;
    }

    public static void main(String[] args) {
        System.out.println(new Q1662().arrayStringsAreEqual2(new String[]{"ab","c"}, new String[]{"a","bc"}));
    }
}
