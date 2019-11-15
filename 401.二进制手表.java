/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<String>();
    int[] watch = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
    int[] onOff = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    public void dfs(int num, int onSum, int start) {
        if (onSum == num) {
            addResult();
            return;
        }
        for (int i = start; i < watch.length; i++) {
            onOff[i] = 1;
            dfs(num, onSum + 1, i + 1);
            onOff[i] = 0;
        }
    }

    public void addResult() {
        int hour = 0;
        int minute = 0;
        for (int i = 0; i < onOff.length; i++) {
            if (onOff[i] == 1) {
                if (i < 4) {
                    hour += watch[i];
                } else {
                    minute += watch[i];
                }
            }
        }
        if (hour > 11 || minute > 59)
            return;
        String time = hour + ":" + ((minute < 10) ? ("0" + minute) : minute);
        res.add(time);
    }

    public List<String> readBinaryWatch(int num) {
        if (num > 8)
            return res;
        dfs(num, 0, 0);
        return res;
    }
}
// @lc code=end
