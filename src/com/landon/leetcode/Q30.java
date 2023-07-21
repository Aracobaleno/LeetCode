package com.landon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30 {
    //朴素Hash表
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        Map<String, Integer> hashMap = new HashMap<>();
        int n = words.length;
        int len1 = words[0].length();
        int len2 = s.length();
        int end = len2 - len1 * n;
        if (len1 * n > len2) return ret;
        for (int i = 0; i < n; i++) {
            hashMap.put(words[i], hashMap.getOrDefault(words[i], 0) + 1);
        }

        out: for (int i = 0; i <= end; i++) {
            Map<String, Integer> cur = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String substring = s.substring(i + j * len1, i + (j + 1) * len1);
                if (!hashMap.containsKey(substring))
                    continue out;
                cur.put(substring, cur.getOrDefault(substring, 0) + 1);
            }
            if (hashMap.equals(cur)) ret.add(i);
        }
        return ret;
    }

    //滑动窗口+哈希表
    public static List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        Map<String, Integer> hashMap = new HashMap<>();
        int n = words.length;
        int len1 = words[0].length();
        int len2 = s.length();
        int end = len2 - len1 * n;
        if (len1 * n > len2) return ret;
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        //for (int i = 0; i < len1; i++)
        return ret;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s, words).toString());
    }
}
