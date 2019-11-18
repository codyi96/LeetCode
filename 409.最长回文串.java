/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }
        int result = 0;
        // 存在一个或多个未成对字符，回文串长度为奇数，即最终值需+1
        boolean hasSingle = false;
        char[] ss = s.toCharArray();
        int[] table = new int[52];
        for (char c : ss) {
            if (c >= 'a' && c <= 'z') {
                table[c - 'a']++;
            } else {
                table[c - 'A' + 26]++;
            }
        }
        for (int i : table) {
            if (i % 2 != 0) {
                hasSingle = true;
                result += (i - 1);
            } else {
                result += i;
            }
        }
        if (hasSingle) {
            result++;
        }
        return result;
    }
}
// @lc code=end

