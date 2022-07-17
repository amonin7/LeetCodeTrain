package com.avminin.string;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String maxString = "";
        for (int center = 0; center < 2 * s.length(); ++center) {
            int cent = center / 2;
            if (center % 2 == 0) {
                int palindromeIterator = 1;
                while (cent + palindromeIterator < s.length()
                        && cent - palindromeIterator >= 0
                        && s.charAt(cent - palindromeIterator) == s.charAt(cent + palindromeIterator)) {
                    ++palindromeIterator;
                }
                --palindromeIterator;
                if (maxString.length() < palindromeIterator * 2 + 1) {
                    maxString = s.substring(cent - palindromeIterator, cent + palindromeIterator + 1);
                }
            } else {
                int palindromeIterator = 0;
                while (cent + palindromeIterator + 1 < s.length()
                        && cent - palindromeIterator >= 0
                        && s.charAt(cent - palindromeIterator) == s.charAt(cent + palindromeIterator + 1)) {
                    ++palindromeIterator;
                }
                --palindromeIterator;
                if (maxString.length() < palindromeIterator * 2 + 2) {
                    maxString = s.substring(cent - palindromeIterator, cent + palindromeIterator + 2);
                }
            }
        }
        return maxString;
    }

}
