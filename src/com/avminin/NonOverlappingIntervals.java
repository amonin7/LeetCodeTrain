package com.avminin;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            if (this.start != o.start)
                return this.start - o.start;
            else
                return this.end - o.end;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Interval[] allIntervals = new Interval[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            allIntervals[i] = new Interval(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(allIntervals);
        int curEnd = allIntervals[0].end;
        int eraseCnt = 0;
        for (int i = 1; i < allIntervals.length; ++i) {
            Interval curInt = allIntervals[i];
            if (curInt.start >= curEnd) {
                curEnd = curInt.end;
            } else if (curInt.end > curEnd) {
                eraseCnt += 1;
            } else {
                curEnd = curInt.end;
                eraseCnt += 1;
            }
        }
        return eraseCnt;
    }
}
