package com.landon.leetcode;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q919 {
}
class CBTInserter {
    //维护两个队列
    /*TreeNode root;
    Queue<TreeNode> candidate;
    public CBTInserter(TreeNode root) {
        this.root = root;
        this.candidate = new ArrayDeque<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left == null || node.right == null) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int parent = node.val;
        if (node.left == null) {
            node.left = child;
        }else {
            node.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return parent;
    }

    public TreeNode get_root() {
        return root;
    }*/

    //维护一个可插入节点的队列
    /*TreeNode root;
    Queue<TreeNode> candidate;
    public CBTInserter(TreeNode root) {
        this.root = root;
        candidate = new ArrayDeque<>();
        candidate.offer(root);
        while (!candidate.isEmpty()) {
            TreeNode node = candidate.peek();
            if (node.left != null) {
                candidate.offer(node.left);
            }
            if (node.right != null) {
                candidate.offer(node.right);
                candidate.poll();
            }
            if (node.left == null || node.right == null) {
                break;
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode parent = candidate.peek();
        int ans = parent.val;
        if (parent.left == null) {
            parent.left = child;
        } else {
            parent.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return ans;
    }

    public TreeNode get_root() {
        return root;
    }*/


    //维护一个list
    List<TreeNode> list = new ArrayList<>();
    int idx = 0;
    public CBTInserter(TreeNode root) {
        list.add(root);
        int cur = 0;
        while (cur < list.size()) {
            TreeNode node = list.get(cur);
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            cur++;
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        while (list.get(idx).left != null && list.get(idx).right != null) idx++;
        TreeNode parent = list.get(idx);
        if (parent.left == null) parent.left = child;
        else parent.right = child;
        list.add(child);
        return list.get(idx).val;
    }

    public TreeNode get_root() {
        return list.get(0);
    }
    /*public CBTInserter(TreeNode root) {

    }

    public int insert(int val) {

    }

    public TreeNode get_root() {

    }*/
}