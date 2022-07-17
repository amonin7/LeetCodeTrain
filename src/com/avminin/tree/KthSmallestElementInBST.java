package com.avminin.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> bst = new ArrayList<>();
        addElementsToBst(root, k, bst);
        return bst.get(k - 1);
    }

    private void addElementsToBst(TreeNode root, int k, List<Integer> bst) {
        if (bst.size() < k) {
            if (root != null) {
                addElementsToBst(root.left, k, bst);
                bst.add(root.val);
                addElementsToBst(root.right, k, bst);
            }
        }
    }
}
