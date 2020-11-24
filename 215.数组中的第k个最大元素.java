/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 数组建大顶堆
        for (int i = nums.length / 2; i >= 0; i--) {
            maxHeapify(nums, i, nums.length);
        }
        // 移除首项并修复大顶堆
        for (int i = 1; i < k; i++) {
            swap(nums, 0, nums.length - i);
            maxHeapify(nums, 0, nums.length - i);
        }
        return nums[0];
    }

    public void maxHeapify(int[] nums, int index, int size) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < size && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < size && nums[right] > nums[largest]) {
            largest = right;
        }
        if(largest != index) {
            // 父节点小于某个子节点，修正大顶堆
            swap(nums, largest, index);
            maxHeapify(nums, largest, size);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

