package com.avminin;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = nums.length * (nums.length + 1) / 2;
        for (int n : nums) {
            res -= n;
        }
        return res;
    }
}
