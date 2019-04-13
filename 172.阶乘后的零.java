/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 *
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/description/
 *
 * algorithms
 * Easy (37.56%)
 * Total Accepted:    10.2K
 * Total Submissions: 27.1K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 
 * 示例 1:
 * 
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * 
 */
class Solution {
    public int trailingZeroes(int n) {
        // 尾数0的个数 = 2-5数字对的个数 = 因数5的个数
        // 一阶：每间隔5，产生一个因数5，如5/10/15
        // 二阶：每间隔25，多产生一个因数5，如25/50/75
        // 以此类推...
        int result = 0;
        while(n >= 5) {
            n /= 5;
            result += n;
        }
        return result;
    }
}

