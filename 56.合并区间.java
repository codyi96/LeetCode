import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> merged = new ArrayList<>();
        for (int[] item : intervals) {
            int left = item[0];
            int right = item[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
                merged.add(new int[]{left, right});
            } else {
                merged.get(merged.size() - 1)[1]
                    = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
// @lc code=end

