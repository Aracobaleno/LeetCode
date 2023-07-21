package com.landon.leetcode;

import java.util.Stack;

public class Q20 {
    //栈括号匹配
    /*public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '('){
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }*/
    //替换光字符串里的"{}","[]","()"
    public boolean isValid(String s) {
       /* while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }*/
        int times = s.length() / 2;
        for (int i = 0; i < times; i++) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Q20().isValid("([])"));
    }
}
