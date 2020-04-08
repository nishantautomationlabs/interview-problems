package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 07/02/20.
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
        curr.next = head;
        ListNode last = head;
        for (int i = 1; i < length - k; i++) {
            last = last.next;
        }
        head = last.next;
        last.next = null;
        return head;
    }
}
