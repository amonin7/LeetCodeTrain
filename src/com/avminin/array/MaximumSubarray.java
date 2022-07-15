package com.avminin.array;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = 0;
        int i = 0;
        int maxMin = Integer.MIN_VALUE;
        while (i < nums.length && nums[i] <= 0) {
            ++i;
            if (maxMin < nums[i]) maxMin = nums[i];
        }
        if (i == nums.length)
            return maxMin;
        for (; i < nums.length; ++i) {
            if (nums[i] < 0 && curSum > maxSum)
                maxSum = curSum;
            curSum += nums[i];
            if (curSum < 0)
                curSum = 0;
        }
        if (curSum > maxSum)
            maxSum = curSum;
        return maxSum;
    }
}
