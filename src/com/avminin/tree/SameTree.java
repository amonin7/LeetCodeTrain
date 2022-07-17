package com.avminin.tree;

public class SameTree {

    public static class TreeNode {
        long val;
        TreeNode left;
        TreeNode right;
        TreeNode(long x) { val = x; }
        TreeNode(long val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
