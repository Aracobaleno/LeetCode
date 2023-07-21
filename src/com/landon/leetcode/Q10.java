package com.landon.leetcode;

public class Q10 {
    //封装
    /*public boolean isMatch(String s, String p) {
        return s.matches(p);
    }*/

    //递归
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {return s.isEmpty();}

        boolean first_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        }else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q10().isMatch("aadafaefa", "."));
    }
}
