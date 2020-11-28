/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int length = s.length();
        int curSize = 0;
        int index = 0;
        while(index < length) {
            char c = s.charAt(index);
            int duplicateIndex = -1;
            for (int j = index - curSize; j < index; j++) {
                // 遍历当前窗口是否包含重复项
                if (c == s.charAt(j)) {
                    duplicateIndex = j;
                    break;
                }
            }
            if (duplicateIndex == -1) {
                // 无重复项，扩张窗口
                curSize++;
                index++;
            } else {
                // 有重复项，收缩窗口，更新max
                max = Math.max(max, curSize);
                curSize = index - duplicateIndex;
                index++;
            }
        }
        return Math.max(max, curSize);
    }
}
// @lc code=end

