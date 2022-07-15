package com.avminin.dynamic.programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MatchsticksToSquare {

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;
        int totalSum = 0;
        matchsticks = Arrays.stream(matchsticks).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        for (int num : matchsticks)
            totalSum += num;
        if (totalSum % 4 != 0) return false;
        return dfs(matchsticks, 0, new int[4], totalSum / 4);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sums, int sideSum) {
        if (index == matchsticks.length) {
            return sums[0] == sums[1] && sums[0] == sums[2] && sums[0] == sums[3];
        }
        for (int i = 0; i < 4; ++i) {
            if (sums[i] + matchsticks[index] <= sideSum) {
                sums[i] += matchsticks[index];
                if (dfs(matchsticks, index + 1, sums, sideSum))
                    return true;
                sums[i] -= matchsticks[index];
            }
        }
        return false;
    }
//    public boolean makesquare(int[] matchsticks) {
//        int length = matchsticks.length;
//        int totalSum = 0;
//        for (int num : matchsticks)
//            totalSum += num;
//        if (totalSum % 4 != 0) return false;
//        for (int i = 0; i < (1 << (2 * length)); ++i) {
//            if (isValidDistribution(i, matchsticks, totalSum))
//                return true;
//        }
//        return false;
//    }
//
//    private boolean isValidDistribution(int distributionNum, int[] matchsticks, int totalSum) {
//        int[] square = new int[4];
//        for (int matchstick : matchsticks) {
//            square[distributionNum % 4] += matchstick;
//            if (square[distributionNum % 4] > totalSum)
//                return false;
//            distributionNum >>= 2;
//        }
//        return square[0] == square[1] && square[0] == square[2] && square[0] == square[3];
//    }

    //    public boolean makesquare(int[] matchsticks) {
//        HashMap<Integer, Integer> countSticks = new HashMap<>();
//        int totalSum = 0;
//        for (int num : matchsticks) {
//            totalSum += num;
//            countSticks.put(
//                    num,
//                    countSticks.getOrDefault(num, 0) + 1
//            );
//        }
//        if (totalSum % 4 != 0) return false;
//        if (countSticks.getOrDefault(totalSum / 4, 0) == 4) return true;
//        return false;
//    }
}
