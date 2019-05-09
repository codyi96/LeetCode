/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {
        return handleNode(root);
    }
    public TreeNode handleNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
        handleNode(left);
        handleNode(right);
        return node;
    }
}

