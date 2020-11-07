/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        // 定义子数组最大和阈值的左右边界
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (nums[i] > left) {
                left = nums[i];
            }
        }
        while (right > left) {
            int mid = (right - left) / 2 + left;
            if (check(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int m, int target) {
        int count = 1;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum + nums[i] > target) {
                count++;
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
        }
        return count <= m;
    }
}
// @lc code=end

