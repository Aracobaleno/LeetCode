package com.landon.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        //暴力破解
/*        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            ArrayList<Character> al = new ArrayList<>();
            for (int j = i; j < s.length(); j++) {
                if (al.contains(s.charAt(j))) {
                    break;
                }
                al.add(s.charAt(j));
                maxLength = Math.max(al.size(), maxLength);
            }
        }
        return maxLength;*/
        //设置扫描窗口
        int maxLength = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxLength = Math.max(j - i, maxLength);
            }else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}
