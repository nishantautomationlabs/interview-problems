package com.nal.leetcode.linkedlist;

import java.util.Stack;

/**
 * Created by nishant on 04/02/20.
 * 234. Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.
 * Example 1:
 * Input: 1->2
 * Output: false
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 */
public class PalindromeLinkedList {

    //O(N) time and O(1) space
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode nodeBeforeMiddle = getNodeBeforeMiddle(head);
        ListNode middleNode = nodeBeforeMiddle.next;
        middleNode = reverseLinkedList(middleNode);
        nodeBeforeMiddle.next = middleNode;
        ListNode curr = head;
        while (middleNode != null) {
            if (curr.val != middleNode.val)
                return false;
            curr = curr.next;
            middleNode = middleNode.next;
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode getNodeBeforeMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //O(N) time and O(N) space
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;
        while (slow != null) {
            if (slow.val != stack.pop())
                return false;
            slow = slow.next;
        }
        return true;
    }
}
