package com.landon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q2325 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> hash = new HashMap<>();
        int i = 0;
        for (char c : key.toCharArray()) {
            if (c!=' ' && !hash.containsKey(c)) {
                hash.put(c, (char)('a'+i++));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : message.toCharArray()) {
            ans.append(hash.getOrDefault(c, ' '));
        }
        return ans.toString();
    }

    public String decodeMessage2(String key, String message) {
        char[] hash = new char[26];
        int i = 0;
        for (char c : key.toCharArray()) {
            if (c == ' ') continue;
            if (hash[c - 'a'] == 0)
                hash[c - 'a'] = (char)('a'+i++);
        }
        StringBuilder ans = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') ans.append(' ');
            else ans.append(hash[c - 'a']);
        }
        return ans.toString();
    }

    public String decodeMessage3(String key, String message) {
        char[] hash = new char[26];
        int i = 0;
        for (char c : key.toCharArray()) {
            if (c == ' ') continue;
            if (hash[c - 'a'] == 0)
                hash[c - 'a'] = (char)('a'+i++);
        }
        char[] messaageCharArr = message.toCharArray();
        for (int j = 0; j < messaageCharArr.length; j++) {
            char c = messaageCharArr[j];
            if(c == ' ') continue;
            else messaageCharArr[j] = hash[c - 'a'];
        }
        return new String(messaageCharArr);
    }
}
