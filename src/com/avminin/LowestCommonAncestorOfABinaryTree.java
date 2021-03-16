package com.avminin;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class NodeWithDepth {
        TreeNode node;
        int depth;

        public NodeWithDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    HashMap<TreeNode, NodeWithDepth> fathers;

    public void assignFathers(TreeNode root, int depth) {
        if (fathers == null) {
            fathers = new HashMap<>();
        }
        if (root.left != null) {
            fathers.put(root.left, new NodeWithDepth(root, depth + 1));
            assignFathers(root.left, depth + 1);
        }
        if (root.right != null) {
            fathers.put(root.right, new NodeWithDepth(root, depth + 1));
            assignFathers(root.right, depth + 1);
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val) {
            return root;
        } else if (q.val == root.val) {
            return root;
        }
        assignFathers(root, 0);
        NodeWithDepth p_fat = fathers.get(p);
        NodeWithDepth q_fat = fathers.get(q);
        if (p_fat.depth - 1 >= q_fat.depth) {
            while (p_fat.depth - 1 > q_fat.depth) {
                p_fat = fathers.get(p_fat.node);
            }
            if (p_fat.node.equals(q)) {
                return q;
            } else {
                p_fat = fathers.get(p_fat.node);
            }
        } else if (p_fat.depth <= q_fat.depth - 1) {
            while (p_fat.depth < q_fat.depth - 1) {
                q_fat = fathers.get(q_fat.node);
            }
            if (q_fat.node.equals(p)) {
                return p;
            } else {
                q_fat = fathers.get(q_fat.node);
            }
        }
        if (q_fat.node.equals(root) || p_fat.node.equals(root)) {
            return root;
        }
        while (!p_fat.node.equals(q_fat.node)) {
            p_fat = fathers.get(p_fat.node);
            q_fat = fathers.get(q_fat.node);
        }
        return p_fat.node;
    }

}
