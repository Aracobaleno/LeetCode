package com.landon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q1260 {
    /*public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> g = new ArrayList<>();
        int[][] temp = new int[m][n];
        for (int i = 0; i < n; i++) {
            int row = (i + k) / n % m, col = (i + k) % n, idx = 0;
            while(idx != m) temp[(row++) % m][col] = grid[idx++][i];
        }
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(temp[i][j]);
            }
            g.add(list);
        }
        return g;
    }*/
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(0);
            }
            g.add(list);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g.get((i * n + j + k) / n % m).set((j + k) % n, grid[i][j]);
            }
        }
        return g;
    }
}
