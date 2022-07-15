package com.avminin.linked.list;

public class LinkedListCycleII {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode curNode = head;
        while (curNode.next != null) {
            curNode.val = Integer.MAX_VALUE;
            if (curNode.next.val == Integer.MAX_VALUE) return curNode.next;
            curNode = curNode.next;
        }
        return null;
    }
}
