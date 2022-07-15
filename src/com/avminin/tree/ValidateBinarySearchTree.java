package com.avminin.tree;

public class ValidateBinarySearchTree {

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

    public boolean isValidBSTWithPar(TreeNode root, long prevValMax, long prevValMin) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.right != null && root.left == null) {
            return root.val < root.right.val && prevValMax > root.right.val
                    && isValidBSTWithPar(root.right, prevValMax, root.val);
        } else if (root.right == null && root.left != null) {
            return root.val > root.left.val && prevValMin < root.left.val
                    && isValidBSTWithPar(root.left, root.val, prevValMin);
        } else {
            boolean left = root.val > root.left.val && prevValMin < root.left.val;
            left = left && isValidBSTWithPar(root.left, root.val, prevValMin);
            boolean right = root.val < root.right.val && prevValMax > root.right.val;
            right = right && isValidBSTWithPar(root.right, prevValMax, root.val);
            return left && right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        
        return isValidBSTWithPar(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

}
