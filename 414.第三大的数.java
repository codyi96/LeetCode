import java.util.HashSet;
import java.util.Iterator;
/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }
        if (numSet.size() < 3) {
            int result = Integer.MIN_VALUE;
            for (int i : numSet) {
                if (i > result) {
                    result = i;
                }
            }
            return result;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        Iterator<Integer> it = numSet.iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
        }
        return max3;
    }
}
// @lc code=end

