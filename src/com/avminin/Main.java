package com.avminin;

import com.avminin.LowestCommonAncestorOfABinaryTree.*;

public class Main {

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t2.right = t4;
        t5.left = t6;
        t5.right = t2;
        t3.left = t5;
        t3.right = t1;


        System.out.println(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(t3, t6, t4));
        Object [] arr = new Object[]{1, null, 3};
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(((int) arr[2]) + ((int) arr[0]));
    }
}
