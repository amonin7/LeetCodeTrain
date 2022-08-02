package com.avminin.array;

public class FirstBadVersion {
    private boolean isBadVersion(int version) {
        switch (version) {
            case 1:
            case 2:
            case 3:
                return false;
            default:
                return true;
        }
//        return true;
    }

    public int firstBadVersion(int n) {
        if (n == 1) return 1;
        if (n == 2) return isBadVersion(1) ? 1 : 2;
        return findBadVersion(1, n) + 1;
    }

    private int findBadVersion(int start, int end) {
        if (start == end) {
            return isBadVersion(start) ? start - 1 : start;
        } else {
            int mid = start + (end - start) / 2;
            boolean badVersionMid = isBadVersion(mid);
            if (badVersionMid) {
                if (mid == start) return start - 1;
                return findBadVersion(start, mid - 1);
            }
            else return findBadVersion(mid + 1, end);
        }
    }

}
