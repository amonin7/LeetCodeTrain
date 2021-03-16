package com.avminin;

public class InvertBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        TreeNode tmp = null;
        if (root.left != null) {
            tmp = invertTree(root.left);
        }
        if (root.right != null) {
            root.left = invertTree(root.right);
        } else {
            root.left = null;
        }
        root.right = tmp;
        return root;
    }

}
