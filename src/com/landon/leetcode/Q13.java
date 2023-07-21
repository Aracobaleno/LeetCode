package com.landon.leetcode;

import javax.print.DocFlavor;
import java.util.HashMap;

public class Q13 {

    // HashMap
    /*public int romanToInt(String s) {
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int ans = 0;
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            if (hash.get(s.charAt(i)) < hash.get(s.charAt(i + 1))) {
                ans -= hash.get(s.charAt(i));
            }else {
                ans += hash.get(s.charAt(i));
            }
        }
        ans += hash.get(s.charAt(len - 1));
        return ans;
    }*/

    // switch
    /*public int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
    *//*public int romanToInt(String s) {
        int ans = 0;
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            if (getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
                ans -= getValue(s.charAt(i));
            }else {
                ans += getValue(s.charAt(i));
            }
        }
        ans += getValue(s.charAt(len - 1));
        return ans;
    }*//*
    // 优化上方方法 存下值 比 每次去找快
    public int romanToInt(String s) {
        int ans = 0;
        int len = s.length();
        int preNum = s.charAt(0);
        for (int i = 1; i < len; i++) {
            int num = s.charAt(i)
            if (preNum < num) {
                ans -= preNum;
            }else {
                ans += preNum;
            }
            preNum = num;
        }
        ans += preNum;
        return ans;
    }*/

    //switch IV, Iv, XL, XC, CD, CM当做整体
    public int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }
    public int romanToInt(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int ans = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            ans += getValue(s.charAt(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("12345555".replace('5', '1'));
    }
}
