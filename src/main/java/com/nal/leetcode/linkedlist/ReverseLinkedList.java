package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 01/02/20.
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        while(head != null)
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {

        if(head.next == null)
            return head;

        ListNode prev = head;
        head = reverseList(head.next);
        prev.next.next = prev;
        prev.next = null;
        return head;
    }
}
