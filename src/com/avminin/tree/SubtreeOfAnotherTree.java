package com.avminin.tree;

public class SubtreeOfAnotherTree {
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

    public boolean isEqualTrees(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else {
            return s.val == t.val && isEqualTrees(s.left, t.left) && isEqualTrees(s.right, t.right);
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else {
            if (s.val == t.val) {
                boolean left = isEqualTrees(s.left, t.left);
                boolean right = isEqualTrees(s.right, t.right);
                if (left && right) {
                    return true;
                }
            }
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

}
