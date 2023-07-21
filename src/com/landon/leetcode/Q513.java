package com.landon.leetcode;


import java.util.ArrayDeque;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Q513 {
    //DFS
    /*int curVal = 0, curHeight = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return curVal;
    }

    public void dfs(TreeNode root, int height) {
        if (root == null) return;
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
    }*/

    //BFS(树从右向左的层次遍历)
    /*public int findBottomLeftValue(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.right != null) queue.offer(p.right);
            if (p.left != null) queue.offer(p.left);
            ret = p.val;
        }
        return ret;
    }*/

    int curVal, curHeight = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return curVal;
    }
    public void dfs(TreeNode root, int height) {
        if (root == null) return;
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;;
        }
    }
}

