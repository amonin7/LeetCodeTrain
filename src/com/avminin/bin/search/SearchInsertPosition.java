package com.avminin.bin.search;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        return searchOne(nums, target, 0, nums.length - 1);
    }

    private int searchOne(int[] nums, int target, int start, int end) {
        if (start >= end) return nums[start] >= target ? start : start + 1;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return searchOne(nums, target, start, mid - 1);
        else return searchOne(nums, target, mid + 1, end);
    }
}
