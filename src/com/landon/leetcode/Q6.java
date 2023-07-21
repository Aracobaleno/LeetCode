package com.landon.leetcode;

public class Q6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] strs = new StringBuilder[numRows];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = new StringBuilder();
        }
        int flag = -1;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            strs[j].append(s.charAt(i));
            if (j == 0 || j == numRows -1) {
                flag *= -1;
            }
            j += flag;
        }
        for (int i = 1; i < numRows; i++) {
            strs[0].append(strs[i] != null ? strs[i] : "");
        }
        return strs[0].toString();
    }
}
;