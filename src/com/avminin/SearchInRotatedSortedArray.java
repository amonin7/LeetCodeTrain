package com.avminin;

public class SearchInRotatedSortedArray {

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

    public static int binSearchElement(int[] nums, int start, int end, int target) {
        if (start == end && nums[start] == target) {
            return start;
        } else if (start == end) {
            return -1;
        } else if (end - start == 1) {
            if (nums[start] > target && nums[end] < target) {
                return -1;
            } else if (nums[start] == target) {
                return start;
            } else {
                return binSearchElement(nums, end, end, target);
            }
        } else {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return binSearchElement(nums, start, mid, target);
            } else {
                return binSearchElement(nums, mid, end, target);
            }
        }
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] != target ||
                nums[nums.length - 1] > nums[0] && (nums[0] > target || nums[nums.length - 1] < target)) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        } else {
            int min_idx;
            int max_idx;
            if (nums[nums.length - 1] > nums[0]) {
                return binSearchElement(nums, 0, nums.length - 1, target);
            } else {
                min_idx = binSearchCustom(nums, 0, nums.length - 1);
                max_idx = min_idx - 1;
                if (target <= nums[nums.length - 1] && target >= nums[min_idx]) {
                    return binSearchElement(nums, min_idx, nums.length - 1, target);
                } else if (target >= nums[0] && target <= nums[max_idx]) {
                    return binSearchElement(nums, 0, max_idx, target);
                } else {
                    return -1;
                }
            }
        }
    }
}
