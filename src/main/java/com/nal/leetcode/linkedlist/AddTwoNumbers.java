package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 03/02/20.
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum, carry = 0;
        ListNode head = null;
        ListNode curr = null;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            sum = v1 + v2 + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            if (head == null) {
                head = newNode;
                curr = head;
            } else {
                curr.next = newNode;
                curr = curr.next;
            }
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        return head;
    }
}
