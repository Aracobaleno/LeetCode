package com.landon.leetcode;

public class Q1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < n; j++) {
                matrix[indices[i][0]][j]++;
            }
            for (int k = 0; k < m; k++) {
                matrix[k][indices[i][1]]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((matrix[i][j] & 1) == 1)
                    ans++;
            }
        }
        return ans;
    }

    //进阶：时间复杂度为 O(n + m + indices.length) 且仅用 O(n + m) 额外空间
    public int oddCells2(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < indices.length; i++) {
            rows[indices[i][0]]++;
            cols[indices[i][1]]++;
        }
        int odd1 = 0;
        for (int i = 0; i < m; i++) {
            if ((rows[i] & 1) == 1)
                odd1++;
        }
        int odd2 = 0;
        for (int i = 0; i < n; i++) {
            if ((cols[i] & 1) == 1)
                odd2++;
        }
        return odd1 * (n - odd2) + (m - odd1) * odd2;
    }

    //Boolean数组开销更小 false是偶数，true是奇数
    public int oddCells3(int m, int n, int[][] indices) {
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < indices.length; i++) {
            rows[indices[i][0]] = !rows[indices[i][0]];
            cols[indices[i][1]] = !cols[indices[i][1]];
        }
        int odd1 = 0, odd2 = 0;
        for (int i = 0; i < m; i++) {
            if(rows[i]) odd1++;
        }
        for (int i = 0; i < n; i++) {
            if(cols[i]) odd2++;
        }
        return odd1 * (n - odd2) + (m - odd1) * odd2;
    }

}
