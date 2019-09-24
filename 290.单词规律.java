import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] chArr = pattern.toCharArray();
        String[] strArr = str.split("\\s+");
        if (chArr.length != strArr.length) {
            // 长度不等 无法一一对应 返回false
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < chArr.length; i++) {
            char curChar = chArr[i];
            String curStr = strArr[i];
            // 从映射表中尝试获取curChar对应的curStr
            String mappingStr = map.containsKey(curChar) ? map.get(curChar) : null;
            if (mappingStr == null) {
                // 映射表中不存在当前char
                if (map.containsValue(curStr)) {
                    // 映射表中已经存在当前str
                    // 说明将会存在多对一映射
                    return false;
                } else {
                    // char / str 均不在映射表中 => 添加映射
                    map.put(curChar, curStr);
                }
            } else {
                // 映射表中存在当前char
                if (!mappingStr.equals(curStr)) {
                    // 映射表中已经存在一个异于当前str的对应值
                    // 说明将会存在一对多映射
                    return false;
                }
            }
            if (map.containsValue(curStr)
                && !map.containsKey(curChar)) {
                // 存在多对一映射 返回false
                return false;
            }
        }
        return true;
    }
}

