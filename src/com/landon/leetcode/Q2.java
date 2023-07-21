package com.landon.leetcode;

import java.util.List;
import java.util.Scanner;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class Q2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;

            carry = sum/10;
            cursor.next = new ListNode(sum%10);
            cursor = cursor.next;

            //超内存
//            if (l1.next != null) {l1 = l1.next;}
//            if (l2.next != null) {l2 = l2.next;}

            if (l1 != null) {l1 = l1.next;}
            if (l2 != null) {l2 = l2.next;}
        }
        return root.next;
    }
    //遍历链表
    public static void traverse (ListNode l) {
        ListNode cursor = l;
        while (cursor != null) {
            System.out.print(cursor.val);
            cursor = cursor.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode p = l1;
        ListNode p1 = l2;
        int[] a1 = {9,9,9,9,9,9,9};
        int[] a2 = {1};
        for (int i : a1) {
            p.next = new ListNode(i);
            p = p.next;
        }
        for (int i : a2) {
            p1.next = new ListNode(i);
            p1 = p1.next;
        }
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String str = scanner.nextLine();
//            if (str.isEmpty()) {
//                break;
//            }
//            String[] array = str.split(" ");
//            for (int i = 0; i < array.length; i++) {
//                p.next = new ListNode(Integer.parseInt(array[i]));
//                p = p.next;
//            }
//        if (scanner.hasNext()) {
//            String str1 = scanner.nextLine();
//            String[] array1 = str1.split(" ");
//            for (int i = 0; i < array1.length; i++) {
//                p1.next = new ListNode(Integer.parseInt(array1[i]));
//                p1 = p1.next;
//            }
//        }
//        scanner.close();
//        }
        traverse(l1.next);
        traverse(l2.next);
        System.out.println("=======================");
        traverse(addTwoNumbers(l1.next, l2.next));
    }
}
