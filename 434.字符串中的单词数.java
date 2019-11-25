/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        int result = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

