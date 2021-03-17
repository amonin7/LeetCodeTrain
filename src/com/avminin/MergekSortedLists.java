package com.avminin;

public class MergekSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode current = new ListNode();
        result = current;
        int cnt = lists.length;
        while (cnt > 0) {
            int min = Integer.MAX_VALUE;
            int min_idx = -1;
            cnt = lists.length;
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] == null) {
                    --cnt;
                    continue;
                }
                if (lists[i].val < min) {
                    min = lists[i].val;
                    min_idx = i;
                }
            }
            if (cnt == 0) {
                break;
            }
            current.next = new ListNode(min);
            current = current.next;
            lists[min_idx] = lists[min_idx].next;
        }
        return result.next;
    }
}
