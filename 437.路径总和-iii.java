import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        return _pathSum(root, sum, new ArrayList<Integer>(), 0);
    }

    private int _pathSum(TreeNode root, int sum, ArrayList<Integer> paths, int lastPath) {
        // 当前节点为空，累计值为0
        if (root == null) {
            return 0;
        }
        // 计算当前节点到根节点的路径长度
        int curPath = lastPath + root.val;
        // 以当前节点为终点的有效路径数
        int mulSum = 0;
        // 初始状态下，如果本节点（根节点）等于期望值，先加一
        if (paths.isEmpty() && root.val == sum) {
            mulSum++;
        }
        // 当前路径到根节点就是有效路径（排除仅有一个节点且为根节点的情况）
        if (!paths.isEmpty() && curPath == sum) {
            mulSum++;
        }
        // 当前节点到根节点路径长度减去历史节点到根节点路径长度等于期望值的，加一
        for (int path : paths) {
            if (curPath - path == sum) {
                mulSum++;
            }
        }
        // 顺便更新下Paths
        paths.add(curPath);
        // 分别计算左右节点
        int leftSum = 0;
        int rightSum = 0;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        if (root.left != null) {
            leftList.addAll(paths);
            leftSum = _pathSum(root.left, sum, leftList, curPath);
        }
        if (root.right != null) {
            rightList.addAll(paths);
            rightSum = _pathSum(root.right, sum, rightList, curPath);
        }
        mulSum += leftSum;
        mulSum += rightSum;
        return mulSum;
    }
}
// @lc code=end

