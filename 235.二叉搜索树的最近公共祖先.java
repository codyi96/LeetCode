/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 利用二叉搜索树性质
        return handleNode(root, p, q);
    }
    public TreeNode handleNode(TreeNode node, TreeNode p, TreeNode q) {
        if ((node.val - p.val) * (node.val - q.val) <= 0) {
            return node;
        }
        if (node.val > p.val) {
            return handleNode(node.left, p, q);
        } else {
            return handleNode(node.right, p, q);
        }
    }
}

