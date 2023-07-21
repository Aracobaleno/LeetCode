package com.landon.leetcode.offer;

//  Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
public class Q24 {
    //借助辅助链表,费空间
/*    public ListNode reverseList(ListNode head) {
        ListNode r = new ListNode(-1);
        ListNode p = head;
        while (p!=null){
            ListNode temp = new ListNode(p.val);
            temp.next = r.next;
            r.next = temp;
            p = p.next;
        }
        return r.next;
    }*/
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null, cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
