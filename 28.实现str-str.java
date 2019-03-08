/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (37.83%)
 * Total Accepted:    38.4K
 * Total Submissions: 101.4K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 */
class Solution {
    public int strStr(String haystack, String needle) {
        // 空集是任何集合的子集
        if ("".equals(needle)) {
            return 0;
        }
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            char curHay = haystack.charAt(i);
            char curNee = needle.charAt(j);
            if (curHay == curNee) {
                j++;
                // 检索完毕 返回
                if (j == needle.length()) {
                    return i - j + 1;
                }
            } else {
                // 未找到相同字符 重新匹配
                if (j - 1 < 0) {
                    j = 0;
                    continue;
                }
                int matchNum = 0;
                String matchStr = needle.substring(0, j);
                // 计算匹配末尾字符的部分匹配值
                for (int m = j - 1; m >= 0; m--) {
                    String preStr = matchStr.substring(0, m + 1);
                    String postStr = matchStr.substring(j - 1 - m);
                    if (!preStr.equals(matchStr)
                        && !postStr.equals(matchStr)
                        && preStr.equals(postStr)) {
                            matchNum = preStr.length();
                            break;
                    }
                }
                // 根据偏移值移动字符串 开始新一轮的匹配
                int offset = j - matchNum;
                i = i - j + offset - 1;
                j = 0;
            }
        }
        return -1;
    }
}
