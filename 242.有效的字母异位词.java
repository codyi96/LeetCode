/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }
        // 本质就是统计各个字母数量是否一致
        int[] ss = new int[26];
        int[] tt = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (char pair : sArr) {
            ss[pair - 'a']++;
        }
        for(char pair : tArr) {
            tt[pair - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ss[i] != tt[i]) {
                return false;
            }
        }
        return true;
    }
}

