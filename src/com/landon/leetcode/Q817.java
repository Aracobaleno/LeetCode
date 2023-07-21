package com.landon.leetcode;

import java.util.HashSet;

public class Q817 {
    public int numComponents(ListNode head, int[] nums) {
        int[] hash = new int[100000];
        for (int num : nums) {
            hash[num]++;
        }
        int count = 0;
        while (head != null) {
            if (hash[head.val] == 1) {
                while (head != null && hash[head.val] == 1) head = head.next;
                count++;
            } else {
                head = head.next;
            }
        }
        return count;
    }

    public int numComponents2(ListNode head, int[] nums) {
        int count = 0;
        HashSet<Integer> hset = new HashSet<>();
        for (int num : nums) {
            hset.add(num);
        }
        while (head != null) {
            if (hset.contains(head.val)) {
                while (head != null && hset.contains(head.val)) head = head.next;
                count++;
            } else {
                head = head.next;
            }
        }
        return count;
    }
}
