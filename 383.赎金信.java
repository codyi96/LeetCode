/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[26];
        for (char m : magazine.toCharArray()) {
            table[m - 'a']++;
        }
        for (char r : ransomNote.toCharArray()) {
            int count = table[r - 'a'];
            if (count == 0) {
                return false;
            }
            table[r - 'a']--;
        }
        return true;
    }
}
// @lc code=end

