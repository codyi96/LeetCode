/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        last.next = null;
        // 每次循环 将last和cur之间的箭头转向
        while(next != null) {
            cur.next = last;
            last = cur;
            cur = next;
            next = next.next;
        }
        cur.next = last;
        return cur;
    }
}

