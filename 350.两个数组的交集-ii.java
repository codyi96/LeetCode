import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            if (map1.containsKey(num)) {
                map1.put(num, map1.get(num) + 1);
            } else {
                map1.put(num, 1);
            }
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (map1.containsKey(num)) {
                int repeat = map1.get(num);
                if (repeat == 1) {
                    map1.remove(num);
                } else {
                    map1.put(num, --repeat);
                }
                resultList.add(num);
            }
        }
        int[] result = new int[resultList.size()];
        int curIndex = 0;
        for (int num : resultList) {
            result[curIndex++] = num;
        }
        return result;
    }
}
// @lc code=end

