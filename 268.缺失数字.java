/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 */
class Solution {
    public int missingNumber(int[] nums) {
        // 相差法： 2ms(86.18%)
        // int size = nums.length;
        // int sum = (1 + size) * size / 2;
        // for (int num : nums) {
        //     sum -= num;
        // }
        // return sum;

        // 异或法： 1ms(99.88%)
        int size = nums.length;
        int result = size;
        for (int i = 0; i < size; i++) {
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }
}

