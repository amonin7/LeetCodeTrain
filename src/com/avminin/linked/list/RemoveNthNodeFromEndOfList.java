package com.avminin.linked.list;

public class RemoveNthNodeFromEndOfList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int curNodeCnt = 0;
        int listLength = 0;
        ListNode cur = head;
        while (cur != null) {
            ++listLength;
            cur = cur.next;
        }
        if (n == listLength) return head.next;
        ListNode parent = head;
        while (curNodeCnt != listLength - n) {
            ++curNodeCnt;
            parent = parent.next;
        }
        parent.next = parent.next.next;
        return head;
    }

}
