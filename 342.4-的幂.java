/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0
        && (num & num - 1) == 0
        // 也可以换成Integer.bitCount为奇数，但此法更快
        && (num & 0x55555555) == num;
    }
}
// @lc code=end

