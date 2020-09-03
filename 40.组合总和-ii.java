import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> item = new ArrayList<>();
        dfs(candidates, target, 0, item, result);
        return result;
    }

    private void dfs(int[] candidates, int target, int begin, List<Integer> item, List<List<Integer>> result) {
        if (target < 0) {
            // 无需继续
            return;
        }
        if (target == 0) {
            // 命中 添加记录
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // add last
            item.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, item, result);
            // remove last
            item.remove(item.size() - 1);
        }
    }
}
// @lc code=end

