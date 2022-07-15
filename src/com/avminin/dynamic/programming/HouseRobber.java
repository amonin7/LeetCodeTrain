package com.avminin.dynamic.programming;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Integer.max(nums[0], nums[1]);
        if (nums.length == 3) return Integer.max(nums[0] + nums[2], nums[1]);
        int[] costs = new int[nums.length];
        costs[0] = nums[0];
        costs[1] = nums[1];
        costs[2] = nums[2] + nums[0];
        for (int i = 3; i < nums.length; ++i) {
            costs[i] = nums[i] + Integer.max(costs[i - 3], costs[i - 2]);
        }
        return Integer.max(costs[nums.length - 1], costs[nums.length - 2]);
    }

    private int robSmaller(int[] nums, int startIndex) {
        if (startIndex >= nums.length) return 0;
        if (startIndex == nums.length - 1) return nums[nums.length - 1];
        return nums[startIndex] + Integer.max(
                robSmaller(nums, startIndex + 2),
                robSmaller(nums, startIndex + 3));
    }
}
