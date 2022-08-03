package com.avminin;

import com.avminin.array.SquaresOfaSortedArray;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaresOfaSortedArray().sortedSquares(new int[]{-10000, -9999, -7, -5, 0, 0, 10000})));
    }
}
