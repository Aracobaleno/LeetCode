package com.landon.leetcode;

public class Q1374 {
    public String generateTheString(int n) {
        StringBuilder strb = new StringBuilder();
        if ((n & 1) == 0) {
            strb.append('b');
            n--;
        }
        while (n-- > 0)
            strb.append('a');
        return strb.toString();
    }

    //(JDK11) String.repeat(n)
    /*public String generateTheString(int n) {
        StringBuilder str = new StringBuilder();
        if ((n & 1) == 1)
            return str.append("a".repeat(n)).toString();
        return str.append("a".repeat(n - 1)).append('b').toString();
    }*/
}
