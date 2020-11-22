/*
 * @lc app=leetcode.cn id=566 lang=java
 *
 * [566] 重塑矩阵
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int line = nums.length;
        int column = nums[0].length;
        if (line * column != r * c) {
            return nums;
        }
        int ll = 0;
        int cc = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[ll][cc];
                cc++;
                if (cc == column) {
                    ll++;
                    cc = 0;
                }
            }
        }
        return result;
    }
}
// @lc code=end

