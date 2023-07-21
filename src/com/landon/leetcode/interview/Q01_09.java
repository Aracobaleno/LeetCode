package com.landon.leetcode.interview;

public class Q01_09 {

    //拼接看是否存在另一个字符串
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s2 + s2).contains(s1);
        //return s1.length() == s2.length() && (s2 + s2).contains(s1);
    }

    //模拟，尝试所有旋转位置，
    public boolean isFlipedString2(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m != n) return false;
        if (n == 0) return true;
        for (int i = 0; i < n; i++) { //旋转位置
            boolean flag = true;
            for (int j = 0; j < n; j++) { //遍历比较两个字符串
                if (s2.charAt(j) != s1.charAt((j + i) % n)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;
        }
        return false;
    }
}
