package com.avminin;

import com.avminin.SubtreeOfAnotherTree.*;

public class Main {

    public static void main(String[] args) {

        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t0 = new TreeNode(0);
        t3.left = t4;
        t4.left = t1;
        t4.right = t2;
        t2.left = t0;
        t3.right = t5;

        TreeNode t44 = new TreeNode(4);
        TreeNode t22 = new TreeNode(2);
        t44.left = t1;
        t44.right = t22;
        System.out.println(new SubtreeOfAnotherTree().isSubtree(t3, t44));
    }
}
