/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (43.01%)
 * Total Accepted:    40.8K
 * Total Submissions: 94.9K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */
class Solution {
    public int maxSubArray(int[] nums) {
        // 结果值
        int res = Integer.MIN_VALUE;
        // 以当前数为结尾的连续子数组的最大和
        int sum = 0;
        for (int n : nums) {
            // 如果前置和为正数，那么最大和必然为前置和+当前数
            if (sum > 0) {
                sum += n;
            // 否则，最大和为当前数
            } else {
                sum = n;
            }
            // 对比已统计的最大和与当前统计的最大和，取最大值赋予结果值
            res = Math.max(res, sum);
        }
        return res;
    }
}

