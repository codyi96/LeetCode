import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (44.80%)
 * Total Accepted:    35.8K
 * Total Submissions: 80K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        } else {
            HashMap<Integer, Integer> solutionCache = new HashMap<>();
            solutionCache.put(1, 1);
            solutionCache.put(2, 2);
            for (int i = 3; i <= n; i++) {
                solutionCache.put(i, solutionCache.get(i - 1) + solutionCache.get(i - 2));
            }
            return solutionCache.get(n);
        }
    }
}

