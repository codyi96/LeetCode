/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int maxIndex = nums[0]; // 当前可跳转的最大索引值
        for (int i = 0; i <= maxIndex && i < nums.length; i++) {
            // 遍历可跳转的所有值，更新可跳转最大索引（越界时退出循环）
            maxIndex = Math.max(maxIndex, nums[i] + i);
        }
        return maxIndex >= nums.length - 1;
    }
}
// @lc code=end

