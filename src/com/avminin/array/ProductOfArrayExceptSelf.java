package com.avminin.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int [] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < nums.length - 1; ++i) {
            res[i + 1] = res[i];
            res[i + 1] *= nums[i];
        }
        int prod = 1;
        for (int i = nums.length - 1; i > 0; --i) {
            prod *= nums[i];
            res[i - 1] *= prod;
        }
        return res;
    }
}
