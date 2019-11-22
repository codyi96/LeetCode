import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        // 高位补齐
        int num1Len = num1.length();
        int num2Len = num2.length();
        int len = num1Len;
        if (num1Len > num2Len) {
            len = num1Len;
            char[] zeroArr = new char[num1Len - num2Len];
            Arrays.fill(zeroArr, '0');
            num2 = String.valueOf(zeroArr) + num2;
        } else if (num2Len > num1Len) {
            len = num2Len;
            char[] zeroArr = new char[num2Len - num1Len];
            Arrays.fill(zeroArr, '0');
            num1 = String.valueOf(zeroArr) + num1;
        }
        // 运算
        boolean addOne = false;
        for (int i = len - 1; i >= 0; i--) {
            int cur = num1.charAt(i) - '0' + num2.charAt(i) - '0';
            // 之前产生进一
            if (addOne) {
                addOne = false;
                cur++;
            }
            // 产生新的进一
            if (cur >= 10) {
                addOne = true;
                cur -= 10;
            }
            sb.append((char) (cur + '0'));
        }
        if (addOne) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

