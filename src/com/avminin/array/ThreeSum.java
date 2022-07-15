package com.avminin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum {

    private List<Integer> makeList(Integer a, Integer b, Integer c) {
        if (a > b) {
            if (b >= c) {
                return List.of(c, b, a);
            } else {
                // c > b
                if (a > c) {
                    return List.of(b, c, a);
                } else {
                    return List.of(b, a, c);
                }
            }
        } else {
            // a < b
            if (a >= c) {
                return List.of(c, a, b);
            } else {
                // a < c
                if (c > b) {
                    return List.of(a, b, c);
                } else {
                    // a < c <= b
                    return List.of(a, c, b);
                }
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        HashMap<Integer, List<Integer>> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int element = nums[i];
            if (numsMap.getOrDefault(element, new ArrayList<>()).isEmpty()) {
                numsMap.put(element, new ArrayList<>());
            }
            numsMap.get(element).add(i);
        }

        for (int elementA : numsMap.keySet()) {
            int target = -elementA;
            for (int elementB : numsMap.keySet()) {
                if (target - elementB == elementB && elementA == elementB) {
                    if (numsMap.getOrDefault(target - elementB, new ArrayList<>()).size() >= 3) {
                        result.add(makeList(elementA, elementA, elementB));
                    }
                } else if (target - elementB == elementB || target - elementB == elementA) {
                    if (numsMap.getOrDefault(target - elementB, new ArrayList<>()).size() >= 2) {
                        result.add(makeList(elementA, elementB, target - elementB));
                    }
                } else if (elementB == elementA) {
                    if (numsMap.getOrDefault(elementB, new ArrayList<>()).size() >= 2 && !numsMap.getOrDefault(target - elementB, new ArrayList<>()).isEmpty()) {
                        result.add(makeList(elementA, elementB, target - elementB));
                    }
                }
                else if (!numsMap.getOrDefault(target - elementB, new ArrayList<>()).isEmpty()) {
                    result.add(makeList(elementA, elementB, target - elementB));
                }
            }
        }

        return new ArrayList<>(result);
    }

}
