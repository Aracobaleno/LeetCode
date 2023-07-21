package com.landon.leetcode;

public class Q1784 {
    public boolean checkOnesSegment(String s) {
        int count = 0, i = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) == '1') {
                while (i < n && s.charAt(i) == '1') i++;
                count++;
            } else {
                i++;
            }
        }
        return count < 2;
    }

    public boolean checkOnesSegment2(String s) {
        return !s.contains("01");
    }

    public static void main(String[] args) {
        System.out.println(new Q1784().checkOnesSegment("1001"));
    }
}

