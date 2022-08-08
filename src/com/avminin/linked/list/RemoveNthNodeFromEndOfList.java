package com.avminin.linked.list;

public class RemoveNthNodeFromEndOfList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode toBeDeleted = head;
        ListNode cur = head;
        for (int i = 0; i < n; ++i) cur = cur.next;
        if (cur == null) {
            head = head.next;
            return head;
        }
        cur = cur.next;
        while (cur != null) {
            cur = cur.next;
            toBeDeleted = toBeDeleted.next;
        }
        toBeDeleted.next = toBeDeleted.next.next;
        return head;
    }

}
