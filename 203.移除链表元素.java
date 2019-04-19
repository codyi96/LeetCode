/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (40.48%)
 * Total Accepted:    22.1K
 * Total Submissions: 54.5K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 
 * 示例:
 * 
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head.val == val) {
            if (head.next == null) {
                return null;
            } else {
                head = head.next;
            }
        }
        ListNode last = head;
        ListNode cur = last.next;
        while(cur != null) {
            if (cur.val == val) {
                last.next = cur.next;
                cur = last.next;
            } else {
                last = last.next;
                cur = cur.next;
            }
        }
        return head;
    }
}

