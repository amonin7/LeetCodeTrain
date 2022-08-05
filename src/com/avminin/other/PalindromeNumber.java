package com.avminin.other;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int xCopy = x;
        int reversed = 0;
        while (xCopy != 0) {
            reversed = reversed * 10 + (xCopy % 10);
            xCopy /= 10;
        }
        return reversed == x;
    }

}
