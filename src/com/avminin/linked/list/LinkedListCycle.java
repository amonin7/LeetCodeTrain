package com.avminin.linked.list;

public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }


    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode curNode = head;
        while (curNode.next != null) {
            curNode.val = Integer.MAX_VALUE;
            if (curNode.next.val == Integer.MAX_VALUE) return true;
            curNode = curNode.next;
        }
        return false;
    }
}
