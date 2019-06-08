/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return badVersionRange(1, n);
    }

    public int badVersionRange(int start, int end) {
        if (start == end) {
            return start;
        }
        if (end - start == 1) {
            if (isBadVersion(start)) {
                return start;
            } else {
                return end;
            }
        }
        int mid = start + (end - start) / 2;
        boolean midResult = isBadVersion(mid);
        if (midResult) {
            return badVersionRange(start, mid);
        } else {
            return badVersionRange(mid, end);
        }
    }
}

