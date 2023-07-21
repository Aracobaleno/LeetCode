package com.landon.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') dq.push(0);
            else {
                int v = dq.pop();
                int top = dq.pop() + Math.max(2 * v, 1);
                dq.push(top);
            }
        }
        return dq.peek();
    }

    public int scoreOfParentheses2(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') ++d;
            else {
                d--;
                if (s.charAt(i - 1) == '(')
                    ans += 1 << d;
            }
        }
        return ans;
    }
}
