/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            int s2 = nums[i2] * 2;
            int s3 = nums[i3] * 3;
            int s5 = nums[i5] * 5;
            int min = Math.min(s2, Math.min(s3, s5));
            nums[i] = min;
            if (s2 == min) i2++;
            if (s3 == min) i3++;
            if (s5 == min) i5++;
        }
        return nums[n - 1];
    }
}
// @lc code=end

