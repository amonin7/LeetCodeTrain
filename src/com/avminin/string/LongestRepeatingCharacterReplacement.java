package com.avminin.string;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s.isEmpty()) {
            return 0;
        }
        int maxLen = 0;
        int curLen = 1;
        int firstOtherIndex = -1;
        int curK = k;
        char curChar = s.charAt(0);
        int curStartIndex = 0;
        int curIndex = 1;
        while (curIndex < s.length()) {
            if (s.charAt(curIndex) == curChar) {
                if (curStartIndex > 0 && (curIndex == s.length() - 1)) {
                    if (curStartIndex > curK) {
                        curLen += curK;
                    } else {
                        curLen += curStartIndex;
                    }
                }
                ++curLen;
            } else if (curK > 0) {
                if (firstOtherIndex == -1) {
                    firstOtherIndex = curIndex;
                }
                --curK;
                if ((curIndex == s.length() - 1) && curStartIndex > 0 && curK > 0) {
                    if (curLen == 1) {
                        --curLen;
                    }
                    if (curStartIndex > curK) {
                        curLen += curK;
                    } else {
                        curLen += curStartIndex;
                    }
                }
                ++curLen;
            } else {
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
                if (firstOtherIndex != -1) {
                    curIndex = firstOtherIndex;
                    firstOtherIndex = -1;
                }
                curChar = s.charAt(curIndex);
                curLen = 1;
                curStartIndex = curIndex;
                curK = k;
            }
            ++curIndex;
        }
        if (curLen > maxLen) {
            maxLen = curLen;
        }
        return maxLen;
    }
}
