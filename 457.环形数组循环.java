/*
 * @lc app=leetcode.cn id=457 lang=java
 *
 * [457] 环形数组循环
 */

// @lc code=start
class Solution {

    private int getIndex(int length, int index) {
        int result = 0;
        if (index < 0) {
            result = length + (index % length);
        } else {
            result = index % length;
        }
        return result;
    }


    public boolean circularArrayLoop(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }
        int[] nums2 = new int[length];
        for (int i = 0; i < length; i++) {
            nums2[i] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            if (nums2[i] == 0) {
                continue;
            }
            // 慢指针
            int curIndex = i;
            int curStep = nums[curIndex];
            // 快指针
            int fastIndex = i;
            int fastStep = nums[fastIndex];
            while(true) {
                int nextIndex = getIndex(length, curIndex + curStep);
                int nextStep = nums[nextIndex];
                // 反向运动，到达当前位置必不可构成循环
                if (curStep * nextStep < 0) {
                    break;
                }
                // 步长小于1，到达当前位置必不可构成循环
                if (curIndex == nextIndex) {
                    break;
                }
                int nextFastIndex = getIndex(length, fastIndex + fastStep);
                int nextFastStep = nums[nextFastIndex];
                // 反向运动，到达当前位置必不可构成循环
                if (curStep * nextFastStep < 0) {
                    break;
                }
                // 步长小于1，到达当前位置必不可构成循环
                if (fastIndex == nextFastIndex) {
                    break;
                }
                int next2FastIndex = getIndex(length, nextFastIndex + nextFastStep);
                int next2FastStep = nums[next2FastIndex];
                // 反向运动，到达当前位置必不可构成循环
                if (curStep * next2FastStep < 0) {
                    break;
                }
                // 步长小于1，到达当前位置必不可构成循环
                if (nextFastIndex == next2FastIndex) {
                    break;
                }
                if (nextIndex == next2FastIndex) {
                    // 快慢指针相遇，实现闭环
                    return true;
                }
                // 进入下一循环
                nums2[curIndex] = 0; // 标记当前路径已尝试
                curIndex = nextIndex;
                curStep = nextStep;
                fastIndex = next2FastIndex;
                fastStep = next2FastStep;
            }
        }
        return false;
    }
}
// @lc code=end

