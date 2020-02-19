package com.nal.leetcode.linkedlist;

import com.nal.leetcode.linkedlist.ListNode;

/**
 * Created by nishant on 31/01/20.
 */
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
