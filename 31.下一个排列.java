/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }
        int i = length - 1;
        while (i - 1 > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        if (nums[i - 1] < nums[i]) {
            // swap
            for (int j = length - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    swap(nums, j, i - 1);
                    break;
                }
            }
            // reverse
            for (int k = i; k < i + (length - i) / 2; k++) {
                swap(nums, k, length - 1 - (k - i));
            }
        } else if (i - 1 == 0) {
            for (int j = 0; j < length / 2; j++) {
                swap(nums, j, length - 1 - j);
            }
        }
    }

    private void swap(int[] nums, int srcIndex, int dstIndex) {
        int tmp = nums[srcIndex];
        nums[srcIndex] = nums[dstIndex];
        nums[dstIndex] = tmp;
    }

}
// @lc code=end

