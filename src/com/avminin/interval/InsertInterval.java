package com.avminin.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static class CustomPoint implements Comparable<CustomPoint> {
        int side;
        boolean isEnd;

        public CustomPoint(int side, boolean isEnd) {
            this.side = side;
            this.isEnd = isEnd;
        }

        @Override
        public int compareTo(CustomPoint o) {
            if (this.side != o.side) {
                return this.side - o.side;
            } else {
                if (!this.isEnd && o.isEnd) {
                    return -1;
                } else if (this.isEnd && o.isEnd) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        CustomPoint[] allIntervals = new CustomPoint[2 * intervals.length + 2];
        for (int i = 0; i < intervals.length; ++i) {
            allIntervals[2 * i] = new CustomPoint(intervals[i][0], false);
            allIntervals[2 * i + 1] = new CustomPoint(intervals[i][1], true);
        }
        allIntervals[2 * intervals.length] = new CustomPoint(newInterval[0], false);
        allIntervals[2 * intervals.length + 1] = new CustomPoint(newInterval[1], true);
        Arrays.sort(allIntervals);
        List<List<Integer>> resList = new ArrayList<>();
        int overlappingCnt = 0;
        int curStart = -1;
        for (CustomPoint allInterval : allIntervals) {
            if (curStart == -1 && !allInterval.isEnd) {
                curStart = allInterval.side;
            }
            if (!allInterval.isEnd) {
                ++overlappingCnt;
            } else {
                --overlappingCnt;
                if (overlappingCnt == 0) {
                    resList.add(List.of(curStart, allInterval.side));
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
