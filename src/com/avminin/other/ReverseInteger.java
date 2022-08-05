package com.avminin.other;

public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while (x >= 10 || x <= -10) {
            res *= 10;
            res += (x % 10);
            x /= 10;
        }
        if (res > (Integer.MAX_VALUE / 10) || res < Integer.MIN_VALUE / 10) {
            return 0;
        }
        return res * 10 + (x % 10);
    }

}
