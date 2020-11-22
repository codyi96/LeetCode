import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为K的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> data = new HashMap<>();
        data.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (data.containsKey(sum - k)) {
                result += data.get(sum - k);
            }
            data.put(sum, data.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
// @lc code=end

