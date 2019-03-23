/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (43.24%)
 * Total Accepted:    34.3K
 * Total Submissions: 79.4K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            if (i == m) {
                result[i + j] = nums2[j];
                j++;
            } else if (j == n) {
                result[i + j] = nums1[i];
                i++;
            } else {
                if (nums1[i] < nums2[j]) {
                    result[i + j] = nums1[i];
                    i++;
                } else {
                    result[i + j] = nums2[j];
                    j++;
                }
            }
        }
        for (int ii = 0; ii < m + n; ii++) {
            nums1[ii] = result[ii];
        }
    }
}

