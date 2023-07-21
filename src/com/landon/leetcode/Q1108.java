package com.landon.leetcode;

public class Q1108 {
    public String defangIPaddr(String address) {
        StringBuilder s = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') s.append("[.]");
            else s.append(c);
        }
        return s.toString();
    }
}
