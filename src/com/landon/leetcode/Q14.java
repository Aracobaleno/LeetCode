package com.landon.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i = 0;
        int len = strs.length;
        while (i < strs[0].length() && i < strs[len - 1].length() && strs[0].charAt(i) == strs[len - 1].charAt(i)) {
            ++i;
        }
        return strs[0].substring(0, 0+i);
    }

    public static void main(String[] args) {
        System.out.println(new Q14().longestCommonPrefix(new String[]{"aaa","aa","aaa"}));
    }
}
