/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int result = 0;
        char lastChar = 0;
        int count = 0;
        for (char c : chars) {
            if (c != lastChar) {
                // 新字符，存储上一个新字符个数
                // 首次进入或仅一个新字符时，不附加个数值
                if (count != 0 && count != 1) {
                    // 附加个数值
                    String countStr = String.valueOf(count);
                    for (int i = 0; i < countStr.length(); i++) {
                        char countChar = countStr.charAt(i);
                        chars[result] = countChar;
                        result++;
                    }
                }
                // 返回数组长度+1、计数器初始化
                chars[result] = c;
                result++;
                count = 1;
                lastChar = c;
            } else {
                // 计数器累加
                count++;
            }
        }
        // 结束，存储上一个新字符个数
        if (count != 0 && count != 1) {
            // 附加个数值
            String countStr = String.valueOf(count);
            for (int i = 0; i < countStr.length(); i++) {
                char countChar = countStr.charAt(i);
                chars[result] = countChar;
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

