package com.landon.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q921 {
    public int minAddToMakeValid(String s) {
        int count = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.offerLast('(');
            else {
                if (stack.isEmpty())
                    count++;
                else
                    stack.pollLast();
            }
        }
        return count + stack.size();
    }

    public int minAddToMakeValid2(String s) {
        int score = 0, count = 0;
        for (char c : s.toCharArray()) {
            score += c == '(' ? 1 : -1;
            if (score < 0) {
                score = 0;
                count++;
            }
        }
        return count + score;
    }
}
