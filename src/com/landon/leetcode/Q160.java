package com.landon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Boolean> hash = new HashMap<>();
        while (headA != null) {
            hash.put(headA, true);
            headA = headA.next;
        }
        while (headB != null) {
            if (hash.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
