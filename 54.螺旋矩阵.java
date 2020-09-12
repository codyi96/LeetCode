import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0
            || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while (left <= right && top <= bottom) {
            for (int a = left; a <= right ; a++) {
                result.add(matrix[top][a]);
            }
            for (int b = top + 1; b <= bottom; b++) {
                result.add(matrix[b][right]);
            }
            if (left < right && top < bottom) {
                for (int c = right - 1; c >= left; c--) {
                    result.add(matrix[bottom][c]);
                }
                for (int d = bottom - 1; d >= top + 1; d--) {
                    result.add(matrix[d][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
// @lc code=end

