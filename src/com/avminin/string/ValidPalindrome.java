package com.avminin.string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int it_start = 0;
        int it_end = s.length() - 1;
        while (it_start <= it_end) {
            if (isNonValid(s.charAt(it_start))) {
                ++it_start;
            } else if (isNonValid(s.charAt(it_end))) {
                --it_end;
            } else {
                if (Character.toLowerCase(s.charAt(it_start)) != Character.toLowerCase(s.charAt(it_end))) {
                    return false;
                } else {
                    --it_end;
                    ++it_start;
                }
            }

        }
        return true;
    }

    private boolean isNonValid(char c) {
        return !Character.isAlphabetic(c) && !Character.isDigit(c);
    }

}
