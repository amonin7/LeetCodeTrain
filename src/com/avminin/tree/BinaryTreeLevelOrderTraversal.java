package com.avminin.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        List<TreeNode> curLevelOrder = List.of(root);

        List<List<Integer>> result = new ArrayList<>();

        while (!curLevelOrder.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            for (TreeNode node : curLevelOrder)
                curLevel.add(node.val);
            result.add(curLevel);
            curLevelOrder = oneLevelOrder(curLevelOrder);
        }

        return result;
    }

    private List<TreeNode> oneLevelOrder(List<TreeNode> parents) {
        List<TreeNode> children = new ArrayList<>();
        for (TreeNode par : parents) {
            if (par.left != null) {
                children.add(par.left);
            }
            if (par.right != null) {
                children.add(par.right);
            }
        }
        return children;
    }

}
