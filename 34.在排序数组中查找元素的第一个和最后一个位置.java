/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                int r1 = mid;
                int r2 = mid;
                while (r1 - 1 >= 0 && nums[r1 - 1] == target) {
                    r1--;
                }
                while (r2 + 1 < nums.length && nums[r2 + 1] == target) {
                    r2++;
                }
                return new int[]{r1, r2};
            }
            if (nums[mid] > target) {
                // 在左侧
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

