package com.landon.leetcode;

public class Q1694 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int p = 0, n = sb.length();
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            if (n > 4) {
                ans.append(sb.substring(p, p + 3) + "-");
                p += 3;
                n -= 3;
            } else {
                if (n == 4) {
                    ans.append(sb.substring(p, p + 2) + "-" + sb.substring(p + 2, p + 4));
                } else {
                    ans.append(sb.substring(p, p + n));
                }
                break;
            }
        }
        return ans.toString();
    }

    public String reformatNumber2(String number) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c == ' ' || c == '-') continue;
            sb.append(c);
            count++;
            if (count == 3) {
                sb.append('-');
                count = 0;
            }
        }
        if (count == 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (count == 1) {
            int len = sb.length();
            char c = sb.charAt(len - 3);
            sb.setCharAt(len - 2, c);
            sb.setCharAt(len - 3, '-');
        }
        return sb.toString();
    }
}
