package com.avminin.dynamic.programming;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] choices = new int[target + 1];

        for (int num : nums) {
            if (num > target) continue;
            choices[num] = 1;
        }

        for (int i = 1; i <= target; ++i) {
            for (int num : nums) {
                if (i - num < 0 || num > target) continue;
                choices[i] += choices[i - num];
            }
        }
        return choices[target];
    }

}
