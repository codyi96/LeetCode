/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] numbers = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            int cur = num & 15;
            sb.append(numbers[cur]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

