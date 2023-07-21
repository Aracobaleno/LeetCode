package com.landon.leetcode.offer.Q09;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class CQueue {
    Deque<Integer> s1, s2;
    public CQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                return -1;
            }
            s1Tos2();
        }
        return s2.pop();
    }

    public void s1Tos2() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
}
