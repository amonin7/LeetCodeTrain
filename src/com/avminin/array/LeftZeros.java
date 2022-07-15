package com.avminin.array;

public class LeftZeros {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                ++i;
            }
            if (i == nums.length) {
                return;
            }
            j = i + 1;
            while (j < nums.length && nums[j] == 0) {
                ++j;
            }
            if (j == nums.length) {
                return;
            }
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            ++i;
            ++j;
        }
    }
}
