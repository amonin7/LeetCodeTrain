package com.avminin;

import java.util.Arrays;
import com.avminin.ReverseLinkedList.ListNode;

public class Main {

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode headNew = new ReverseLinkedList().reverseList(l1);
        System.out.println(headNew.val);
    }
}
