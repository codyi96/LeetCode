import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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

    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        handleNode(root, String.valueOf(root.val));
        return result;
    }

    public void handleNode(TreeNode node, String path) {
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }
        path += "->";
        if (node.left != null) {
            handleNode(node.left, path + String.valueOf(node.left.val));
        }
        if (node.right != null) {
            handleNode(node.right, path + String.valueOf(node.right.val));
        }
    }
}

