import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            } else {
                numSet.add(num);
            }
        }
        return false;
    }
}

