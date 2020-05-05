package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 07/02/20.
 * 61. Rotate List
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            length++;
            curr = curr.next;
        }
        k = k % length;
        if (k == 0)
            return head;
        curr.next = head;  //curr is at the last node
        ListNode last = head;
        for (int i = 1; i < length - k; i++) {
            last = last.next;
        }
        head = last.next;
        last.next = null;
        return head;
    }
}
