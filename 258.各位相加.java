/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */
class Solution {
    public int addDigits(int num) {
        int result = num % 9;
        if (result == 0) {
            result = num == 0 ? 0 : 9;
        }
        return result;
    }
}

