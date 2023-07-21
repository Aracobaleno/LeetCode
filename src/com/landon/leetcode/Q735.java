package com.landon.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean alive = true;
            while (alive) {
                if (stack.isEmpty() || asteroid > 0) {
                    stack.push(asteroid);
                    alive =false;
                } else if (asteroid < 0 && stack.peek() < 0) {
                    stack.push(asteroid);
                    alive = false;
                } else if (asteroid < 0 && stack.peek() > 0 && alive) {
                    if (stack.peek() > Math.abs(asteroid)) {
                        alive = false;
                    } else if (stack.peek() < Math.abs(asteroid)) {
                        stack.pop();
                    } else {
                        stack.pop();
                        alive = false;
                    }
                }
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = stack.pollLast();
        }
        return ans;
    }
    public int[] asteroidCollision2(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean alive = true;
            while (alive && !stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (stack.peek() >= -asteroid)
                    alive = false;
                if (stack.peek() <= -asteroid)
                    stack.pop();
            }
            if (alive)
                stack.push(asteroid);
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = stack.pollLast();
        }
        return ans;
    }

    public int[] asteroidCollision3(int[] asteroids) {
        int top = -1, n = asteroids.length;
        int[] stack = new int[n];
        for (int i = 0; i < n; i++) {
            if (top != -1 && stack[top] > 0 && asteroids[i] < 0) {
                if (stack[top] + asteroids[i] > 0) continue;
                else if (stack[top] + asteroids[i] < 0) i--;
                top--;
            } else stack[++top] = asteroids[i];
        }
        return Arrays.copyOfRange(stack, 0, top++);
    }
}
