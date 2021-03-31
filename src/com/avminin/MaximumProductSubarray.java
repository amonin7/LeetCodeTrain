package com.avminin;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int product = 0;
        int max_product = 0;
        int cnt_product = 0;
        int cnt_negative = 0;
        int negative_left = 0;
        int negative_right = 0;
        int cumulative_product_left = 1;
        int cumulative_product_right = 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                if (negative_left == 0) {
                    cumulative_product_left *= nums[i];
                }
                if (negative_right != 0) {
                    cumulative_product_right *= nums[i];
                }
                if (product == 0) {
                    product = 1;
                }
                product *= nums[i];
                ++cnt_product;
            } else if (nums[i] < 0) {
                if (product == 0) {
                    product = 1;
                }
                product *= nums[i];
                ++cnt_negative;
                ++cnt_product;
                if (negative_left == 0) {
                    negative_left = nums[i];
                    product = 0;
                }
                cumulative_product_right = 1;
                negative_right = nums[i];
            } else {
                if (product == 0 && cnt_product == 0) {
                    continue;
                }
                if (cnt_negative % 2 == 0 && cnt_negative != 0) {
                    product *= cumulative_product_left;
                    product *= negative_left;
                } else if (cnt_negative == 1) {
                    if (cnt_product == 1) {
                        product = 0;
                    } else {
                        product = Math.max(cumulative_product_left, cumulative_product_right);
                    }
                } else {
                    if (Math.abs(cumulative_product_left * negative_left)
                            > Math.abs(cumulative_product_right * negative_right)) {
                        product = (product / (cumulative_product_right * negative_right))
                                * cumulative_product_left * negative_left;
                    }
                }
                if (product > max_product) {
                    max_product = product;
                }
                product = 0;
                cnt_product = 0;
                cnt_negative = 0;
                negative_left = 0;
                negative_right = 0;
                cumulative_product_left = 1;
                cumulative_product_right = 1;
            }
        }
        if (cnt_negative % 2 == 0 && cnt_negative != 0) {
            product *= cumulative_product_left;
            product *= negative_left;
        } else if (cnt_negative == 1) {
            if (cnt_product == 1) {
                product = 0;
            } else {
                product = Math.max(cumulative_product_left, cumulative_product_right);
            }
        } else {
            if (Math.abs(cumulative_product_left * negative_left)
                    > Math.abs(cumulative_product_right * negative_right)) {
                product = (product / (cumulative_product_right * negative_right))
                        * cumulative_product_left * negative_left;
            }
        }
        if (product > max_product) {
            max_product = product;
        }
        return max_product;
    }
}
