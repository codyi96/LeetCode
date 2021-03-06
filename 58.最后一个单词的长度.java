import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (28.86%)
 * Total Accepted:    19.3K
 * Total Submissions: 66.9K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 
 * 示例:
 * 
 * 输入: "Hello World"
 * 输出: 5
 * 
 * 
 */
class Solution {
    public int lengthOfLastWord(String s) {
        String regex = "(?:[\\s\\S]*\\s)?([a-zA-Z]+)\\s*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return matcher.group(1).length();
        } else {
            return 0;
        }
    }
}

