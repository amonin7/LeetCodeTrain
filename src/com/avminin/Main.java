package com.avminin;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] arr = new int[]{0,1,0,3,12};
        new LeftZeros().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
