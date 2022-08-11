package com.avminin.tree;

public class PopulatingNextRightPointersInEachNodeII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Node cur = root;
        while (cur != null) {
            Node childHead = null;
            Node child = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (childHead == null) {
                        childHead = cur.left;
                        child = cur.left;
                    } else {
                        child.next = cur.left;
                        child = child.next;
                    }
                }
                if (cur.right != null) {
                    if (childHead == null) {
                        childHead = cur.right;
                        child = cur.right;
                    } else {
                        child.next = cur.right;
                        child = child.next;
                    }
                }
                cur = cur.next;
            }
            cur = childHead;
        }
        return root;
    }

}
