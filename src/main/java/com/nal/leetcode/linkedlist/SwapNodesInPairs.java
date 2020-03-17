package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 09/03/20.
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode next = curr.next;
            ListNode next_next = next.next;
            curr.next = next_next;
            next.next = next_next.next;
            next_next.next = next;

            curr = curr.next.next;
        }
        return dummy.next;
    }
}
