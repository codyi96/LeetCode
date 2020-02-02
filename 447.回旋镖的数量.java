import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 */

// @lc code=start
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                double distance = computeDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                int value = map.containsKey(distance) ? map.get(distance) : 0;
                map.put(distance, ++value);
            }
            for (int times : map.values()) {
                if (times >= 2) {
                    result += (times * (times - 1));
                }
            }
        }
        return result;
    }

    private double computeDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + (Math.pow(y1 - y2, 2)));
    }
}
// @lc code=end

