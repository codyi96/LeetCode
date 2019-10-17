import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {

    public List<Character> vowels = Arrays.asList(
        'a', 'e', 'i', 'o', 'u',
        'A', 'E', 'I', 'O', 'U'
    );

    public String reverseVowels(String s) {
        char[] ss = s.toCharArray();
        int len = ss.length;
        char left = '\0';
        char right = '\0';
        for (int i = 0, j = len - 1; i <= j;) {
            if (left == '\0') {
                if (isVowel(ss[i])) {
                    left = ss[i];
                }
                i++;
            } else {
                if (isVowel(ss[j])) {
                    right = ss[j];
                }
                j--;
            }
            if (left != '\0' && right != '\0') {
                ss[i - 1] = right;
                ss[j + 1] = left;
                left = '\0';
                right = '\0';
            }
        }
        return new String(ss);
    }

    public boolean isVowel(char c) {
        return vowels.contains(c);
    }
}
// @lc code=end

