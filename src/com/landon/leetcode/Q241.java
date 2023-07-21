package com.landon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q241 {
    //递归1
    /*public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        int len = expression.length();
        int num = 0;
        int index = 0;
        while (index < len && !isOperation(expression.charAt(index))) {
            num = num * 10 + (expression.charAt(index++) - '0');
        }
        if (index == len) {
            res.add(num);
            return res;
        }
        for (int i = 0; i < len; i++) {
            if (isOperation(expression.charAt(i))) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        char op = expression.charAt(i);
                        res.add(calculate(left.get(j), op, right.get(k)));
                    }
                }
            }
        }
        return res;
    }

    public int calculate(int a, char op, int b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }

    public boolean isOperation(char c){
        return c == '+' || c == '-' || c == '*';
    }*/

    //递归2
    char[] chars;
    public List<Integer> diffWaysToCompute(String s) {
        chars = s.toCharArray();
        return DFS(0, chars.length - 1);
    }
    List<Integer> DFS(int start, int end) {
        List<Integer> ans = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') continue;
            List<Integer> l = DFS(start, i - 1), r = DFS(i + 1, end);
            for (int a : l) {
                for (int b : r) {
                    int num = 0;
                    char op = chars[i];
                    switch (op) {
                        case '+': num = a + b; break;
                        case '-': num = a - b; break;
                        case '*': num = a * b;
                    }
                    ans.add(num);
                }
            }
        }
        if (ans.isEmpty()) {
            int num = 0;
            for (int i = start; i <= end; i++)
                num = num * 10 + (chars[i] - '0');
            ans.add(num);
        }
        return ans;
    }
}
