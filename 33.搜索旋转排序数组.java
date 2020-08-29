/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2; // 'start + (end - start) / 2' may be better
            if (nums[mid] == target) {
                return mid;
            }
            // 正常升序数组 mid 位的值应该大于 start 位的值
            if (nums[mid] >= nums[start]) {
                // start ~ mid 为正常升序数组
                if (target >= nums[start] && target <= nums[mid]) {
                    // target ∈ [start, mid]
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // mid ~ end 为正常升序数组
                if (target >= nums[mid] && target <= nums[end]) {
                    // target ∈ [mid, end]
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

