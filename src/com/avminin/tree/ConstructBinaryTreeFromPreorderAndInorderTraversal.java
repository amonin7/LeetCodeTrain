package com.avminin.tree;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    int preorderIndex = 0;
    HashMap<Integer, Integer> rootPos;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        rootPos = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            rootPos.put(inorder[i], i);
        }
        preorderIndex = 0;
        return buildSubTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode buildSubTree(
            int[] preorder,
            int inRangeStart,
            int inRangeEnd) {
        if (inRangeStart > inRangeEnd)
            return null;
        int rootValue = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootValue);
        preorderIndex += 1;
        root.left = buildSubTree(preorder, inRangeStart, rootPos.get(rootValue) - 1);
        root.right = buildSubTree(preorder, rootPos.get(rootValue) + 1, inRangeEnd);
        return root;
    }

}
