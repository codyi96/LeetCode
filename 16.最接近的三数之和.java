import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 返回的值是最接近target的三数和
        int result = 20000; // |20000 - 3000| > |-10000 - 3000|
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int curTarget = nums[first] + nums[second] + nums[third];
                if (curTarget == target) {
                    // 找到一个等值答案，不必再往下算了
                    return curTarget;
                }
                if (Math.abs(result - target) > Math.abs(curTarget - target)) {
                    result = curTarget;
                }
                if (curTarget > target) {
                    // 右指针左移
                    third--;
                } else {
                    // 左指针右移
                    second++;
                }
            }
        }
        return result;
    }
}
// @lc code=end

