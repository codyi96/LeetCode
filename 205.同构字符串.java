import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // 排除极端情况
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        // 正常处理流程
        HashMap<Character, Character> data = new HashMap<>();
        char[] origin = s.toCharArray();
        char[] target = t.toCharArray();
        int size = s.length();
        for(int i = 0; i < size; i++) {
            char ori = origin[i];
            char tar = target[i];
            if (!data.containsKey(ori)) {
                if (data.containsValue(tar)) {
                    return false;
                }
                data.put(ori, tar);
            } else {
                if (tar != data.get(ori)) {
                    return false;
                }
            }
        }
        return true;
    }
}

