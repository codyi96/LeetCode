import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = candidates.length;
        if (length == 0) {
            return result;
        }
        List<Integer> item = new ArrayList<>();
        dfs(candidates, target, 0, item, result);
        return result;
    }

    private void dfs(int[] candidates, int target, int begin, List<Integer> item, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            item.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, item, result);
            item.remove(item.size() - 1);
        }
    }
}
// @lc code=end

