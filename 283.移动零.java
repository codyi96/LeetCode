/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int insertAt = 0;
        for (int lookAt = 0; lookAt < nums.length; lookAt++) {
            if (nums[lookAt] != 0) {
                nums[insertAt] = nums[lookAt];
                insertAt++;
            }
        }
        for (int polyfill = insertAt; polyfill < nums.length; polyfill++) {
            nums[polyfill] = 0;
        }
    }
}

