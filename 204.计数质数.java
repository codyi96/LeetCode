/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode-cn.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (27.18%)
 * Total Accepted:    15.9K
 * Total Submissions: 58.4K
 * Testcase Example:  '10'
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * 
 * 示例:
 * 
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 */
class Solution {
    public int countPrimes(int n) {
        // 极端情况处理
        if (n <= 2) {
            return 0;
        } else if (n <= 3) {
            return 1;
        } else if (n <= 5) {
            return 2;
        }
        int result = 0;
        // 初始化时 默认全为素数
        // isNotPrime[i]=true 表示i不是素数
        // 第一位 isNotPrime[0] 丢弃不用
        boolean[] isNotPrime = new boolean[n];
        // 要统计n以内的素数 只需统计Math.sqrt(n)+1以内的素数 再划掉其素数的倍数
        int end = (int) (Math.sqrt(n) + 1);
        for (int i = 2; i <= end; i++) {
            if (!isNotPrime[i]) {
                result++;
                for (int j = 2; i * j < n; j++) {
                    isNotPrime[i * j] = true;
                }
            }
        }
        for (int i = end + 1; i < n; i++) {
            if (!isNotPrime[i]) {
                result++;
            }
        }
        return result;
    }
}

