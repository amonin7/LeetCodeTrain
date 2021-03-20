package com.avminin;

import com.avminin.ValidateBinarySearchTree.*;

public class Main {

    public static void main(String[] args) {

        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(7);
        TreeNode t4 = new TreeNode(6);
        TreeNode t1 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t4.left = t3;
        t4.right = t6;
        t5.left = t1;
        t5.right = t4;
        System.out.println(new ValidateBinarySearchTree().isValidBST(t5));
    }
}
