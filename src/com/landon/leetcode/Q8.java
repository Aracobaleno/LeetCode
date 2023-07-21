package com.landon.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q8 {
    //正常解法
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int idx = 0;
        boolean flag = true;
        int ans = 0;
        //去除前导零
        while (idx < len && chars[idx] == ' ') {
            ++idx;
        }
        if (idx == len) {
            return 0;
        }
        //确定符号
        if (chars[idx] == '-') {
            flag = false;
            ++idx;
        }else if (chars[idx] == '+') {
            ++idx;
        }else if (!Character.isDigit(chars[idx])) { //没有数字
            return 0;
        }
        int last = 0;
        while (idx < len && Character.isDigit(chars[idx])) {
            last = ans;
            ans = ans * 10 + (chars[idx] - '0');
            //有无越界，负数越过 MAX_VALUE 都为 MIN_VALUE
            if (ans / 10 !=  last) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ++idx;
        }
        return flag ? ans : -ans;
    }
    //正则表达式
    /*public int myAtoi(String s) {
        Matcher matcher = Pattern.compile("^[\+\-]?\d+").matcher(s);
    }*/

    public static void main(String[] args) {
        System.out.println(new Q8().myAtoi("-2147483645"));
    }
}
