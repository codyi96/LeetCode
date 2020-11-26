/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            boolean modify = false;
            if (nums[left] <= nums[right]) {
                if (nums[left + 1] >= nums[left]) {
                    left++;
                    modify = true;
                }
                if (nums[right - 1] <= nums[right]) {
                    right--;
                    modify = true;
                }
            }
            if (!modify) {
                break;
            }
        }
        if (left == right) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        while (right < nums.length - 1 && nums[right + 1] < max) {
            right++;
        }
        if (left == right) {
            return 0;
        }
        return right - left + 1;
    }
}
// @lc code=end

