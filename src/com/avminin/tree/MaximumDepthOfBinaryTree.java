package com.avminin.tree;

public class MaximumDepthOfBinaryTree {
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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int left = maxDepth(root.left) + 1;
            int right = maxDepth(root.right) + 1;
            return Math.max(left, right);
        }
    }

}
