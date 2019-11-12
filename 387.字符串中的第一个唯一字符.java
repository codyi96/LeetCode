/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] table = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            table[c - 'a']++;
        }
        for(int i = 0; i < cs.length; i++) {
            if (table[cs[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

