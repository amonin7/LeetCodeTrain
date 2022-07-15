package com.avminin;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Integer.max(nums[0], nums[1]);
        if (nums.length == 3) return Integer.max(Integer.max(nums[0], nums[2]), nums[1]);
        int first = nums[0];
        nums[0] = 0;
        int firstSum = robOne(nums);
        nums[0] = first;
        nums[nums.length - 1] = 0;
        return Integer.max(firstSum, robOne(nums));
    }

    private int robOne(int[] nums) {
        int[] costs = new int[nums.length];
        costs[0] = nums[0];
        costs[1] = nums[1];
        costs[2] = nums[2] + nums[0];
        for (int i = 3; i < nums.length; ++i) {
            costs[i] = nums[i] + Integer.max(costs[i - 3], costs[i - 2]);
        }
        return Integer.max(costs[nums.length - 1], costs[nums.length - 2]);
    }

}
