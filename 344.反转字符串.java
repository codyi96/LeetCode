/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        // 奇数: 重复 (len - 1) / 2 次
        // 偶数: 重复 len / 2 次
        int repeat = s.length / 2;
        for (int i = 0; i < repeat; i++) {
            int j = s.length - 1 - i;
            char a = s[i];
            s[i] = s[j];
            s[j] = a;
        }
    }
}
// @lc code=end

