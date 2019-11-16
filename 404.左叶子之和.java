/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    int result = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果是左叶子，累计数值
        if (root.left != null
            && root.left.left == null
            && root.left.right == null) {
            result += root.left.val;
        } else {
            // 如果非左叶子，递归左节点
            sumOfLeftLeaves(root.left);
        }
        // 递归右节点
        sumOfLeftLeaves(root.right);
        return result;
    }
}
// @lc code=end

