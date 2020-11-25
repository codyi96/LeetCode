/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] points = new int[primes.length];
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int markJ = 0;
            for (int j = 0; j < primes.length; j++) {
                int next = primes[j] * nums[points[j]];
                if (next < min) {
                    markJ = j;
                    min = next;
                }
            }
            points[markJ]++;
            if (min == nums[i - 1]) {
                i--;
                continue;
            }
            nums[i] = min;
        }
        return nums[n - 1];
    }
}
// @lc code=end

