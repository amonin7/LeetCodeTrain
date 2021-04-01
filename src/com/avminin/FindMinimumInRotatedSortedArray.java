package com.avminin;

public class FindMinimumInRotatedSortedArray {

    public static int binSearchCustom(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        } else if (end - start == 1) {
            if (nums[end] > nums[start]) {
                return start;
            } else {
                return end;
            }
        } else {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                return binSearchCustom(nums, mid, end);
            } else {
                return binSearchCustom(nums, start, mid);
            }
        }
    }

    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) {
            return nums[0];
        } else {
            return nums[binSearchCustom(nums, 0, nums.length - 1)];
        }
    }

}
