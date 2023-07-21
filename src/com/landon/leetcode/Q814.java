package com.landon.leetcode;

//Definition for a binary tree node.

public class Q814 {
    public TreeNode pruneTree(TreeNode root) {
        /*if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0)
            return null;
        return root;*/

        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left != null || root.right != null)
            return root;
        return root.val == 0 ? null : root;
    }
}
