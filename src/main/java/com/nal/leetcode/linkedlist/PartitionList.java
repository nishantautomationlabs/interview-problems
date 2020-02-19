package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 11/02/20.
 * 86. Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode less = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode lessIter = less;
        ListNode greaterIter = greater;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                lessIter.next = curr;
                lessIter = lessIter.next;
            } else {
                greaterIter.next = curr;
                greaterIter = greaterIter.next;
            }
            curr = curr.next;
        }
        lessIter.next = greater.next;
        greaterIter.next = null;

        return less.next;
    }
}
