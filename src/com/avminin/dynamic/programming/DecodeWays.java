package com.avminin.dynamic.programming;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int[] numWays = new int[s.length()];
        numWays[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        for (int i = s.length() - 2; i >= 0; --i) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') return 0;
                numWays[i] = numWays[i + 1];
                numWays[i - 1] = numWays[i + 1];
                if (i == 1) {
                    break;
                } else if (i == 2) {
                    numWays[i - 2] = numWays[i];
                    break;
                } else {
                    numWays[i - 2] = numWays[i];
                    i -= 2;
                }
            } else if (s.charAt(i) > '2' || s.charAt(i) == '2' && s.charAt(i + 1) >= '7')
                numWays[i] = numWays[i + 1];
            else if (i == s.length() - 2)
                numWays[i] = numWays[i + 1] + 1;
            else
                numWays[i] = numWays[i + 1] + numWays[i + 2];
        }
        return numWays[0];
    }

}
