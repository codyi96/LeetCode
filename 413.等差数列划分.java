import jdk.internal.agent.resources.agent;

/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int result = 0;
        int count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i + 2] - A[i + 1] == A[i + 1] - A[i]) {
                count++;
            } else {
                result += (count + 1) * count / 2;
                count = 0;
            }
        }
        return result += (count + 1) * count / 2;
    }
}
// @lc code=end

