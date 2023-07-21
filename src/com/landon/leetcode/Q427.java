package com.landon.leetcode;

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

public class Q427 {
    //递归
    /*int[][] g;
    public Node construct(int[][] grid) {
        g = grid;
        return dfs(0, 0, g.length - 1, g.length -1);
    }
    Node dfs(int a, int b, int c, int d) {
        int leftTop = g[a][b];
        boolean isLeaf = true;
        for (int i = a; i <= c; i++) {
            for (int j = b; j <= d; j++) {
                if (g[i][j] != leftTop)
                    isLeaf = false;
            }
        }
        if (isLeaf) return new Node(leftTop == 1, true);
        Node root = new Node(leftTop == 1, false;
        int dx = (c - a) / 2;
        root.topLeft = dfs(a, b, a + dx, b + dx);
        root.topRight = dfs(a, d - dx, a + dx, d);
        root.bottomLeft = dfs(c - dx, b, c, b + dx);
        root.bottomRight = dfs(c - dx, d - dx, c, d);
        return root;
    }*/

    //前缀和优化递归
    static int[][] sum = new int[65][65];
    int[][] g;
    public Node construct(int[][] grid) {
        g = grid;
        int n = grid.length;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + g[i - 1][j - 1];
            }
        }
        return dfs(0, 0, n - 1, n - 1);
    }
    Node dfs(int a, int b, int c, int d) {
        int cur = sum[c + 1][d + 1] - sum[c + 1][b] - sum[a][d + 1] + sum[a][b];
        int dx = (c - a) / 2, tol = (c - a + 1) * (c - a + 1);
        if (cur == 0 || cur == tol) return new Node(g[a][b] == 1, true);
        Node root = new Node(g[a][b] == 1, false);
        root.topLeft = dfs(a, b, a + dx, b + dx);
        root.topRight = dfs(a, d - dx, a + dx, d);
        root.bottomLeft = dfs(c - dx, b, c, b + dx);
        root.bottomRight = dfs(c - dx, d - dx, c, d);
        return root;
    }
}
