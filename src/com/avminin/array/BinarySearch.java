package com.avminin.array;

public class BinarySearch {
    public int search(int[] nums, int target) {
        return searchOne(0, nums.length - 1, nums, target);
    }

    private int searchOne(int start, int end, int[] nums, int target) {
        if (start == end) {
            return nums[start] == target ? start : -1;
        } else if (end - start == 1) {
            if (nums[start] == target) return start;
            else if (nums[end] == target) return end;
            else return -1;
        } else {
            int mid = (end + start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) return searchOne(start, mid, nums, target);
            else return searchOne(mid, end, nums, target);
        }
    }
}
