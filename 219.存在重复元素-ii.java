import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// 题目描述中，“判断数组中是否存在两个不同的索引 i 和 j，
// 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k”
// 存在歧义，暂以此法解之
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> data = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                // 滑动窗口 窗口大小为k
                // 当窗口滑动超过k时，移除最早加入窗口的元素
                data.remove(nums[i - k - 1]);
            }
            // data集合存储了当前窗口的元素
            // 如果重复 即表示存在索引差绝对值小于等于k的相等数
            if (!data.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}

