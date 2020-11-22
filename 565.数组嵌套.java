/*
 * @lc app=leetcode.cn id=565 lang=java
 *
 * [565] 数组嵌套
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            }
            int count = 0;
            int cur = nums[i]; // start must be > 0
            nums[i] *= -1;
            do {
                count++;
                cur = Math.abs(nums[cur]);
                if (nums[cur] > 0) {
                    nums[cur] *= -1;
                }
            } while (cur != Math.abs(nums[i]));
            result = Math.max(result, count);
        }
        return result;
    }
}
// @lc code=end

