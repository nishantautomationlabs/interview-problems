package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 01/02/20.
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
