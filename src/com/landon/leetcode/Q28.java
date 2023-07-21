package com.landon.leetcode;

import java.util.LinkedList;

public class Q28 {
    //循环遍历 有误子串及其起始位置
    /*public int strStr(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        int cur = 0, mark = 0;
        if (needle == "") {return 0;}
        for (int i = 0; i < len1; i++) {
            if (haystack.charAt(i) == needle.charAt(cur)) {
                mark = 1;
                if (len1 - i < len2 - cur) {return -1;}
                if (cur == len2 -1) {
                    return i - len2 + 1;
                }
                ++cur;
            }else if (mark == 1) {
                i = i - cur;
                cur = 0;
                mark = 0;
            }
        }
        return -1;
    }*/



    //更清楚的单次遍历 双指针
    /*public int strStr(String haystack, String needle) {
        int m = 0, n = 0;
        int len1 = haystack.length(), len2 = needle.length();
        while (m < len1 && n < len2) {
            if (haystack.charAt(m) == needle.charAt(n)) {
                ++m;
                ++n;
            }else {
                m = m - n + 1;
                n = 0;
            }
        }
        if (n == len2) {
            return m - n;
        }else {
            return -1;
        }
    }*/

    //清晰地BF（暴力）算法（显示回退)
    /*public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i <= m - n; ++i) {
            int j;
            for (j = 0; j < n; ++j) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }*/

    //BM算法（坏字符，好后缀）
    /*public int strStr(String hayStack, String needle) {

    }
    //求坏字符情况下移动位数
    public void badChar(String needle, int needLen, int[] ){

    }*/

    //KMP算法

    /*public static void main(String[] args) {
        System.out.println(new Q28().strStr("mississippi", "issip"));
    }*/
    public int numIdenticalPairs(int[] nums) {
        int[] hash = new int[101];
        int ans = 0;
        for (int j = 0; j < nums.length; ++j) {
            ans += hash[ nums[j] ];
            ++hash[nums[j]];
        }
        return ans;
    }
}
