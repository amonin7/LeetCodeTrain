package com.avminin;

/// leetcode.com/problems/merge-two-sorted-lists/
public class Merge2SortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode cur = root;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                ListNode child = new ListNode();
                child.val = list2.val;
                cur.next = child;
                list2 = list2.next;
            } else if (list1.val < list2.val) {
                ListNode child = new ListNode();
                child.val = list1.val;
                cur.next = child;
                list1 = list1.next;
            } else {
                ListNode child = new ListNode();
                child.val = list1.val;
                cur.next = child;
                cur = cur.next;
                child = new ListNode();
                child.val = list2.val;
                cur.next = child;
                list1 = list1.next;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        while (list1 != null) {
            ListNode child = new ListNode();
            child.val = list1.val;
            cur.next = child;
            cur = cur.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            ListNode child = new ListNode();
            child.val = list2.val;
            cur.next = child;
            cur = cur.next;
            list2 = list2.next;
        }
        cur.next = null;
        return root.next;
    }

}
