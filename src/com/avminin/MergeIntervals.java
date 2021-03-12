package com.avminin;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public static class CustomPoint implements Comparable<CustomPoint> {
        int side;
        boolean isEnd;

        public CustomPoint(int side, boolean isEnd) {
            this.side = side;
            this.isEnd = isEnd;
        }

        @Override
        public int compareTo(CustomPoint point) {
            if (this.side != point.side) {
                return this.side - point.side;
            } else {
                if (!this.isEnd && point.isEnd) {
                    return -1;
                } else if (this.isEnd && point.isEnd) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
    }

    boolean compareCustomPoint (CustomPoint point1, CustomPoint point2) {
        return point1.side < point2.side || point1.side == point2.side && !point1.isEnd;
    }

    public int[][] merge(int[][] intervals) {
        CustomPoint [] all_ints = new CustomPoint[2 * intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            all_ints[2 * i] = new CustomPoint(intervals[i][0], false);
            all_ints[2 * i + 1] = new CustomPoint(intervals[i][1], true);
        }
        Arrays.sort(all_ints);
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        int curStart = -1;
        int curCnt = 0;
        int curResIndex = 0;
        for (int i = 0; i < all_ints.length; ++i) {
            if (curStart == -1 && !all_ints[i].isEnd) {
                curStart = all_ints[i].side;
            }
            if (!all_ints[i].isEnd) {
                ++curCnt;
            } else {
                --curCnt;
                if (curCnt == 0) {
                    ArrayList<Integer> newInt = new ArrayList<>();
                    newInt.add(curStart);
                    newInt.add(all_ints[i].side);
                    resList.add(newInt);
                    curStart = -1;
                }
            }
        }
        int [][] res = new int[resList.size()][2];
        for (int i = 0; i < res.length; ++i) {
            res[i][0] = resList.get(i).get(0);
            res[i][1] = resList.get(i).get(1);
        }
        return res;
    }
}
