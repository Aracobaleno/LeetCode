package com.landon.leetcode;

public class Q1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] map = new int[2];
        for (int i : students) map[i]++;
        for (int i : sandwiches) if (map[i]-- == 0) return map[i ^ 0];
        return 0;
    }
}
