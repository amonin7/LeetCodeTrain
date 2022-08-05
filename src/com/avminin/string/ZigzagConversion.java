package com.avminin.string;

import java.util.StringJoiner;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) builders[i] = new StringBuilder();
        if (numRows == 1) return s;
        for (int cycle = 0; cycle < s.length() / (numRows + numRows - 2) + 1; ++cycle) {
            for (int cycleIdx = 0; cycleIdx < (numRows + numRows - 2); ++cycleIdx) {
                int charIdx = cycle * (numRows + numRows - 2) + cycleIdx;
                if (charIdx >= s.length()) break;
                if (cycleIdx < numRows) builders[cycleIdx].append(s.charAt(charIdx));
                else builders[2 * numRows - cycleIdx - 2].append(s.charAt(charIdx));
            }
        }
        String res = "";
        for (int i = 0 ; i < numRows; ++i) res = res.concat(builders[i].toString());
        return res;
    }

}
