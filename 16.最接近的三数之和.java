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
        int result = 20000; // max target
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            int third = nums.length - 1;
            for (int second = first + 1; second < third; second++) {
                int curTarget = nums[first] + nums[second] + nums[third];
                if (curTarget == target) {
                    // 找到一个等值答案，不必再往下算了
                    return curTarget;
                }
                while (second < third && nums[first] + nums[second] + nums[third] > target) {
                    // 左移third指针，找到临界点
                    third--;
                }
                curTarget = nums[first] + nums[second] + nums[third];
                if (second == third) {
                    // 比较临界值的右侧点
                    if (third != nums.length - 1) {
                        int lastTarget = nums[first] + nums[second] + nums[third + 1];
                        if (Math.abs(result - target) > Math.abs(lastTarget - target)) {
                            result = lastTarget;
                        }
                        // 恢复到临界值右侧点
                        third++;
                    }
                    // 双指针相遇，退出循环
                    break;
                }
                // 比较临界值的左侧点，即当前点
                if (Math.abs(result - target) > Math.abs(curTarget - target)) {
                    result = curTarget;
                }
                // 比较临界值的右侧点
                if (third != nums.length - 1) {
                    int lastTarget = nums[first] + nums[second] + nums[third + 1];
                    if (Math.abs(result - target) > Math.abs(lastTarget - target)) {
                        result = lastTarget;
                    }
                    // 恢复到临界值右侧点
                    third++;
                }
            }
        }
        return result;
    }
}
// @lc code=end

