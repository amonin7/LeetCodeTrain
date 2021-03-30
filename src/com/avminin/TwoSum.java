package com.avminin;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> values = new HashMap<>();

        int[] integerArray = new int[2];

        for (int i = 0; i < nums.length; ++i) {
            int element = nums[i];
            if (values.getOrDefault(element, new ArrayList<>()).isEmpty()) {
                values.put(element, new ArrayList<>());
                values.get(element).add(i);
            } else {
                values.get(element).add(i);
            }
        }
        for (int element : nums) {
            if (target - element == element) {
                if (values.getOrDefault(target - element, new ArrayList<>()).size() >= 2) {
                    integerArray[0] = values.get(target - element).get(0);
                    integerArray[1] = values.get(target - element).get(1);
                    return integerArray;
                }
            } else if (!values.getOrDefault(target - element, new ArrayList<>()).isEmpty()) {
                integerArray[0] = values.get(element).get(0);
                integerArray[1] = values.get(target - element).get(0);
                return integerArray;
            }
        }
        return integerArray;
    }
}
