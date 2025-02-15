package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 01/02/20.
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
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
