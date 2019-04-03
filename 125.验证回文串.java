/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (38.74%)
 * Total Accepted:    29.8K
 * Total Submissions: 77K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        s = s.toLowerCase();
        int j = s.length() - 1;
        for (int i = 0; i < j; i++) {
            if (isValid(s.charAt(i))) {
                while(!isValid(s.charAt(j))) {
                    j--;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    System.out.println(s.charAt(i));
                    System.out.println(s.charAt(j));
                    return false;
                }
                j--;
            }
        }
        return true;
    }

    public boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}

