package com.avminin.string;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        int maxLen = 0;
        int curLen = 0;
        int curWindowStart = 0;
        for (int i = 0; i < s.length(); ++i) {
            char curChar = s.charAt(i);
            if (lastIndex.containsKey(curChar) && lastIndex.get(curChar) >= curWindowStart) {
                if (curLen > maxLen) maxLen = curLen;
                curLen = i - lastIndex.get(curChar);
                curWindowStart = lastIndex.get(curChar) + 1;
                lastIndex.put(curChar, i);
//                ++curLen;
            } else {
                lastIndex.put(curChar, i);
                ++curLen;
            }
        }
        if (curLen > maxLen) maxLen = curLen;
        return maxLen;
    }

}
