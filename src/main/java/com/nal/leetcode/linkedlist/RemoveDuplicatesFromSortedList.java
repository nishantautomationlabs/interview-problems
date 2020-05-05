package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 06/02/20.
 * 83. Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if(head == null || head.next == null)
            return head;
        head.next = deleteDuplicatesRecursive(head.next);
        if(head.val == head.next.val)
            return head.next;
        return head;
    }

    public ListNode deleteDuplicatesIterative(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return head;
    }
}
