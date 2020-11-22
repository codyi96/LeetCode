/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }
        return Math.max(result, count);
    }
}
// @lc code=end

