package com.avminin;

import com.avminin.MergekSortedLists.*;

public class Main {

    public static void main(String[] args) {
        ListNode l13 = new ListNode(5);
        ListNode l12 = new ListNode(4, l13);
        ListNode l11 = new ListNode(1, l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3, l23);
        ListNode l21 = new ListNode(1, l22);

        ListNode l32 = new ListNode(6);
        ListNode l31 = new ListNode(2, l32);

        new MergekSortedLists().mergeKLists(new ListNode[]{l11, l21, l31});
    }
}
