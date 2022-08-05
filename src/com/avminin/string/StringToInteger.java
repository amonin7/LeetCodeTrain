package com.avminin.string;

public class StringToInteger {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int charsIdx = 0;
        int res = 0, sign = 1;
        while (charsIdx < chars.length && chars[charsIdx] == ' ') ++charsIdx;
        if (charsIdx == chars.length) return 0;
        if (chars[charsIdx] == '-') {
            sign = -1;
            ++charsIdx;
        } else if (chars[charsIdx] == '+') {
            ++charsIdx;
        }
        if (charsIdx == chars.length) return 0;
//        int first = -1;
//        while (charsIdx < chars.length && Character.isDigit(chars[charsIdx])) {
//            if (first == -1) first = chars[charsIdx] - '0';
//            if (res >= (Integer.MAX_VALUE / 10)) {
//                if (res / 1_000_000_000 != 0) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//                if ((chars[charsIdx] - '0' > 8 || first > 2) && sign == -1) return Integer.MIN_VALUE;
//                if ((chars[charsIdx] - '0' > 7 || first > 2) && sign == 1) return Integer.MAX_VALUE;
//
//                if (charsIdx < chars.length - 1 && Character.isDigit(chars[charsIdx + 1])) {
//                    if ((chars[charsIdx + 1] - '0' > 7 || first > 2) && sign == 1) return Integer.MAX_VALUE;
//                    else if ((chars[charsIdx + 1] - '0' > 8 || first > 2) && sign == -1) return Integer.MIN_VALUE;
//                    else if (res / 1_000_000_000 != 0) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//                }
//            }
//            res *= 10;
//            res += chars[charsIdx] - '0';
//            ++charsIdx;
//        }
        while (charsIdx < chars.length && Character.isDigit(chars[charsIdx])) {
            if (res / 100_000_000 != 0) {
                if (res > Integer.MAX_VALUE / 10) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                else if (res == Integer.MAX_VALUE / 10) {
                    if ((chars[charsIdx] - '0' > 8) && sign == -1) return Integer.MIN_VALUE;
                    if ((chars[charsIdx] - '0' > 7) && sign == 1) return Integer.MAX_VALUE;
                }
            }
            res *= 10;
            res += chars[charsIdx] - '0';
            ++charsIdx;
        }
        return res * sign;
    }
}
