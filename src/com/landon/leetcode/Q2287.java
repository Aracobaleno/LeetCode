package com.landon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q2287 {
    public static int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> hash1 = new HashMap<>(), hash2 = new HashMap<>();
        char[] sc = s.toCharArray(), targetc = target.toCharArray();
        for (char c : sc) {
            hash1.put(c, hash1.getOrDefault(c, 0) + 1);
        }
        for (char c : targetc) {
            hash2.put(c, hash2.getOrDefault(c, 0) + 1);
        }
        System.out.println(hash1.getOrDefault((char)('a' + 2), 0));
        int ans = 100;
        for (int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            if (hash2.getOrDefault(c, 0) > 0) {
                ans = Math.min(ans, hash1.getOrDefault(c, 0)/hash2.get(c));
            }
        }
        return ans;
    }

    public static int rearrangeCharacters2(String s, String target) {
        int[] hash1 = new int[26], hash2 = new int[26];
        for (char c : s.toCharArray()) {
            ++hash1[c - 'a'];
        }
        for (char c : target.toCharArray()) {
            ++hash2[c - 'a'];
        }
        int ans = 100;
        for (int i = 0; i < 26; i++) {
            if (hash2[i] > 0) {
                ans = Math.min(ans, hash1[i]/hash2[i]);
                if (ans == 0) return 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Q2287().rearrangeCharacters("ilovecodingonleetcode", "code"));
    }
}
