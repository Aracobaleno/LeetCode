package com.landon.leetcode;

import java.util.*;

public class Q515 {
    //DFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        dfs(root, 0, ret);
        return ret;
    }

    public void dfs(TreeNode root, int curHeight, List<Integer> ret) {
        if (root == null) return;
        if (curHeight == ret.size()) {
            ret.add(root.val);
        }else {
            ret.set(curHeight, Math.max(ret.get(curHeight), root.val));
        }
        dfs(root.left, curHeight + 1, ret);
        dfs(root.right, curHeight + 1, ret);
    }

    //BFS
    /*public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            while (len > 0) {
                len--;
                TreeNode t = queue.poll();
                max = Math.max(max, t.val);
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
            }
            ret.add(max);
        }
        return ret;
    }*/
}
