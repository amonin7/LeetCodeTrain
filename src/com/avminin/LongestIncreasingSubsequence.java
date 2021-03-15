package com.avminin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LongestIncreasingSubsequence {

    class Point implements Comparable<Point> {
        int val;
        int idx;

        public Point(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point o) {
            if (val - o.val != 0) {
                return val - o.val;
            } else {
                return idx - o.idx;
            }
        }
    }

    public int lengthOfLIS(int[] nums) {
        Point [] pts = new Point[nums.length];
        HashMap<Point, Integer> lengths = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            pts[i] = new Point(nums[i], i);
            lengths.put(pts[i], 1);
        }
        Arrays.sort(pts);
        int maxLen = 1;
        for (int i = 0; i < nums.length; ++i) {
            Point cur = new Point(nums[i], i);
            int idx = Arrays.binarySearch(pts, cur);
            for (int j = idx + 1; j < pts.length; ++j) {
                if (pts[j].val == cur.val) {
                    continue;
                }
                if (cur.idx < pts[j].idx && lengths.get(pts[idx]) + 1 > lengths.get(pts[j])) {
                    lengths.replace(pts[j], lengths.get(pts[idx]) + 1);
                }
            }
        }
        return Collections.max(lengths.values());
    }
}
