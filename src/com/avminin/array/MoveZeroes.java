package com.avminin.array;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lastZeroIdx = 0;
        while (lastZeroIdx < nums.length && nums[lastZeroIdx] != 0) ++lastZeroIdx;
        int lastNonZeroIdx = lastZeroIdx;
        while (lastNonZeroIdx < nums.length && nums[lastNonZeroIdx] == 0) ++lastNonZeroIdx;
        if (lastNonZeroIdx == nums.length) return;
        while (lastNonZeroIdx < nums.length) {
            int tmp = nums[lastZeroIdx];
            nums[lastZeroIdx] = nums[lastNonZeroIdx];
            nums[lastNonZeroIdx] = tmp;
            while (lastZeroIdx < nums.length && nums[lastZeroIdx] != 0) ++lastZeroIdx;
            while (lastNonZeroIdx < nums.length && nums[lastNonZeroIdx] == 0) ++lastNonZeroIdx;
        }
    }

}
