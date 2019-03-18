import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (46.94%)
 * Total Accepted:    18.5K
 * Total Submissions: 39.4K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        int aLen = a.length();
        int bLen = b.length();
        boolean forward = false;
        for (int i = aLen - 1, j = bLen - 1; i >= 0 || j >= 0; i--, j--) {
            int cur = forward ? 1 : 0;
            if (i >= 0 && a.charAt(i) == '1') {
                cur++;
            }
            if (j >= 0 && b.charAt(j) == '1') {
                cur++;
            }
            switch (cur) {
                case 0:
                    result = "0" + result;
                    forward = false;
                    break;
                case 1:
                    result = "1" + result;
                    forward = false;
                    break;
                case 2:
                    result = "0" + result;
                    forward = true;
                    break;
                case 3:
                    result = "1" + result;
                    forward = true;
                    break;
            }
        }
        if (forward) {
            result = "1" + result;
        }
        return result;
    }
}

