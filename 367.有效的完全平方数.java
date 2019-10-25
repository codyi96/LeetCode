/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        // 牛顿迭代法
        int i = num;
        while (num / i < i) {
            i = (i + num / i) / 2;
        }
        return i * i == num;
    }
}
// @lc code=end
