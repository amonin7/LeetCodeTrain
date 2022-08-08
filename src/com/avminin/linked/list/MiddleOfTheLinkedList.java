package com.avminin.linked.list;

public class MiddleOfTheLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int cnt = 1;
        while (cur.next != null) {
            ++cnt;
            cur = cur.next;
        }
        cur = head;
        int mid = cnt / 2 + 1;
        for (int i = 0; i < mid - 1; ++i) cur = cur.next;
        return cur;
    }

}
