package com.avminin;

public class CountingBits {

    public int[] countBits(int n) {
        if (n == 0) return new int[] {0};
        if (n == 1) return new int[] {0, 1};
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        int curPow = 1;
        int nextPow = 2;
        for (int i = 2; i <= n; ++i) {
            if (i == nextPow) {
                curPow = nextPow;
                nextPow *= 2;
                result[i] = 1;
            } else {
                result[i] = result[i - curPow] + 1;
            }
        }

        return result;
    }

}
