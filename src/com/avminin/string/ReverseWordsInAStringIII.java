package com.avminin.string;

public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int startIdx = 0, endIdx = 0;
        while (startIdx < s.length()) {
            while (endIdx < s.length() && chars[endIdx] != ' ') ++endIdx;
            for (int i = startIdx, j = endIdx - 1; i < j; ++i, --j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
            startIdx = endIdx + 1;
            endIdx += 1;
        }
        return String.valueOf(chars);
    }

}
