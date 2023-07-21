package com.landon.leetcode.test;

import java.util.Arrays;

public class Q14 {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i = 0;
        int len = strs.length;
        while (i < strs[0].length() && i < strs[len - 1].length() && strs[0].charAt(i) == strs[len - 1].charAt(i)) {
            ++i;
        }
        return strs[0].substring(0, 0+i);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","azsefaefaefae","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
