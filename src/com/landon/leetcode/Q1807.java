package com.landon.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> hash = new HashMap<>();
        for (List<String> kv: knowledge) {
            hash.put(kv.get(0), kv.get(1));
        }
        StringBuilder ans = new StringBuilder();
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (cs[i] == '('){
                StringBuilder temp = new StringBuilder();
                while (cs[++i] != ')') temp.append(cs[i]);
                ans.append(hash.getOrDefault(temp.toString(), "?"));
            }else {
                ans.append(cs[i]);
            }
        }
        return ans.toString();
    }
}
