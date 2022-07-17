package com.avminin.string;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int palindromeCounter = 0;
        for (int center = 0; center < 2 * s.length(); ++center) {
            int cent = center / 2;
            int palindromeIterator = 0;
            if (center % 2 == 0) {
                while (cent + palindromeIterator < s.length()
                        && cent - palindromeIterator >= 0
                        && s.charAt(cent - palindromeIterator) == s.charAt(cent + palindromeIterator)) {
                    ++palindromeIterator;
                }
            } else {
                while (cent + palindromeIterator + 1 < s.length()
                        && cent - palindromeIterator >= 0
                        && s.charAt(cent - palindromeIterator) == s.charAt(cent + palindromeIterator + 1)) {
                    ++palindromeIterator;
                }
            }
            palindromeCounter += palindromeIterator;
        }
        return palindromeCounter;

    }

}
