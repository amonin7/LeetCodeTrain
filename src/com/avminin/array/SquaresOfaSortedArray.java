package com.avminin.array;

public class SquaresOfaSortedArray {

    public int[] sortedSquares(int[] nums) {
        if (nums.length == 1) return new int[]{nums[0] * nums[0]};
        int[] result = new int[nums.length];
        int changeIndex = 0;
        while (changeIndex < nums.length && nums[changeIndex] < 0) ++changeIndex;
        int leftIdx = changeIndex - 1, rightIdx = changeIndex;
        int resultIdx = 0;
        while (changeIndex < nums.length && nums[changeIndex] == 0) {
            result[resultIdx] = 0;
            ++changeIndex;
            rightIdx += 1;
            resultIdx += 1;
        }
        while (leftIdx >= 0 && rightIdx < nums.length) {
            int left = -nums[leftIdx];
            if (left > nums[rightIdx]) {
                result[resultIdx] = nums[rightIdx] * nums[rightIdx];
                ++resultIdx;
                ++rightIdx;
            } else if (left == nums[rightIdx]) {
                result[resultIdx] = left * left;
                ++resultIdx;
                --leftIdx;
                result[resultIdx] = nums[rightIdx] * nums[rightIdx];
                ++resultIdx;
                ++rightIdx;
            } else {
                result[resultIdx] = left * left;
                ++resultIdx;
                --leftIdx;
            }
        }
        while (leftIdx >= 0) {
            int left = -nums[leftIdx];
            result[resultIdx] = left * left;
            ++resultIdx;
            --leftIdx;
        }
        while (rightIdx < nums.length) {
            result[resultIdx] = nums[rightIdx] * nums[rightIdx];
            ++resultIdx;
            ++rightIdx;
        }
        return result;
    }

}
