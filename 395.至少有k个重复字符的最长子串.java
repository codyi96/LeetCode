/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有K个重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        int[] data = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            data[s.charAt(i) - 'a']++;
        }
        // 检查全局是否即目标子串
        boolean isFullString = true;
        for (int i = 0; i < 26; i++) {
            if (data[i] > 0 && data[i] < k) {
                isFullString = false;
                break;
            }
        }
        if (isFullString) {
            return length;
        }
        // 左右先剔除
        int left = 0;
        int right = length - 1;
        while(right - left + 1 >= k
            && data[s.charAt(left) - 'a'] > 0
            && data[s.charAt(left) - 'a'] < k) {
                left++;
        }
        while(right - left + 1 >= k
            && data[s.charAt(right) - 'a'] > 0
            && data[s.charAt(right) - 'a'] < k) {
                right--;
        }
        if (right - left + 1 < k) {
            return 0;
        }
        // 切割
        int max = 0;
        isFullString = true;
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (data[c - 'a'] > 0 && data[c - 'a'] < k) {
                max = Math.max(longestSubstring(s.substring(left, i), k),
                    longestSubstring(s.substring(i), k));
                    isFullString = false;
            }
        }
        if (isFullString) {
            return right - left + 1;
        }
        return max;
    }
}
// @lc code=end

