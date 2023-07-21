package com.landon.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q901 {
}

class StockSpanner {
    Deque<int[]> stack;
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int day = 1;
        while (!stack.isEmpty() && price >= stack.peekLast()[1]) {
            day += stack.pollLast()[0];
        }
        stack.offerLast(new int[]{day, price});
        return day;
    }
}
