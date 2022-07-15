package com.avminin.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int left = 0, right = matrix[0].length, bottom = matrix.length, top = 0;

        while (left != right && bottom != top) {

            for (int i = left; i < right; ++i) {
                result.add(matrix[top][i]);
            }
            ++top;
            if (top == bottom){
                break;
            }
            for (int i = top; i < bottom; ++i) {
                result.add(matrix[i][right - 1]);
            }
            --right;
            if (left == right){
                break;
            }
            for (int i = right - 1; i >= left; --i) {
                result.add(matrix[bottom - 1][i]);
            }
            --bottom;
            if (top == bottom){
                break;
            }
            for (int i = bottom - 1; i >= top; --i) {
                result.add(matrix[i][left]);
            }
            ++left;
            if (left == right){
                break;
            }
        }

        return result;
    }
}
