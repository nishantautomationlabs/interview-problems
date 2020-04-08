package com.nal.leetcode.linkedlist;

import com.nal.leetcode.linkedlist.ListNode;

/**
 * Created by nishant on 06/02/20.
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
