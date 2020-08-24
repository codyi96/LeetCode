import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int first = 0; first < length - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < length - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = second + 1;
                int fourth = length - 1;
                while (third < fourth) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        third++;
                        continue;
                    }
                    int curTarget = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (curTarget == target) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[first]);
                        item.add(nums[second]);
                        item.add(nums[third]);
                        item.add(nums[fourth]);
                        result.add(item);
                        third++;
                    } else if (curTarget > target) {
                        fourth--;
                    } else {
                        third++;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

