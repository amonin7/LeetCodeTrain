package com.avminin.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {

    class Frequency implements Comparable<Frequency> {
        int number;
        int freq;

        public Frequency(int number, int freq) {
            this.number = number;
            this.freq = freq;
        }

        @Override
        public int compareTo(Frequency o) {
            if (this.freq != o.freq) {
                return this.freq - o.freq;
            } else {
                return this.number - o.number;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0) + 1);
        }

        List<Frequency> frequencies = new ArrayList<>();

        numsMap.forEach((Integer num, Integer freq) -> frequencies.add(new Frequency(num, freq)));
        Collections.sort(frequencies);

        int [] res = new int[k];

        for (int i = 0; i < k; ++i) {
            res[i] = frequencies.get(frequencies.size() - 1 - i).number;
        }

        return res;
    }

}
