package com.avminin.linked.list;

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

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = new ListNode(head.val, null);
        while (head.next != null) {
            ListNode next = new ListNode(head.next.val, cur);
            cur = new ListNode(next.val, next.next);
            head = new ListNode(head.next.val, head.next.next);
        }
        return cur;
    }

}
