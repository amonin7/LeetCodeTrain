package com.avminin.array;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        HashMap<Integer, Integer> lengths = new HashMap<>();
        for (int j : nums) {
            Integer cur = lengths.get(j);
            if (cur != null) continue;
            lengths.put(j, 1);
        }
        int max = 0;
        for (Integer num : lengths.keySet()) {
            if (lengths.get(num) != 1) continue;
            Integer next = lengths.get(num + 1);
            int cnt = 1;
            if (next != null) {
                while (next != null) {
                    if (next == 1) {
                        cnt += 1;
                    } else {
                        cnt += next;
                        break;
                    }
                    next = lengths.get(num + cnt);
                }
                for (int i = cnt; i >= 0; --i)
                    lengths.replace(num + i, cnt);
            }
            if (cnt > max) max = cnt;
        }
        return max;
    }
}
