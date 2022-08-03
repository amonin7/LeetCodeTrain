package com.avminin.array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (n == 1 || k == 0) return;
        int cnt = 0;
        for (int i = 0; cnt < nums.length; ++i) {
            int curIdx = i;
            int curElement = nums[i];
            int newElement;
            do {
                curIdx = (curIdx + k) % n;
                newElement = nums[curIdx];
                nums[curIdx] = curElement;
                curElement = newElement;
                ++cnt;
            } while (curIdx != i);
        }

//        for (int start = 0; count < nums.length; start++) {
//            int current = start;
//            int prev = nums[start];
//            do {
//                int next = (current + k) % nums.length;
//                int temp = nums[next];
//                nums[next] = prev;
//                prev = temp;
//                current = next;
//                count++;
//            } while (start != current);
//        }

    }

    private int mcd(int a, int b) {
        return (a == 0 || b == 0) ? a + b : mcd(b, a % b);
    }

}
