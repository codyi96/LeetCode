/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int sl = s.length();
        if (sl == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        int tOffset = 0;
        for (int i = 0; i < sl; i++) {
            char c = s.charAt(i);
            tOffset = t.indexOf(c);
            if (tOffset == -1) {
                return false;
            }
            t = t.substring(tOffset + 1);
        }
        return true;
    }
}
// @lc code=end

