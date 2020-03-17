package com.nal.leetcode.linkedlist;

import java.util.Stack;

/**
 * Created by nishant on 16/03/20.
 * 143. Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example 1:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        slow = reverseList(slow);

        head = mergeLists(head, slow);
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return l1;
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = l1;
        while(l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;

            if(l1Next != null) {
                l2.next =  l1Next;
            }
            l1 = l1Next;
            l2 = l2Next;
        }
        return head;
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList.reorderList2(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = null;
            stack.push(slow);
            slow = next;
        }

        slow = head;
        ListNode newCurr = new ListNode(-1);

        while (slow != null && !stack.isEmpty()) {
            ListNode next = slow.next;
            newCurr.next = slow;
            newCurr = newCurr.next;
            newCurr.next = stack.pop();
            newCurr = newCurr.next;
            slow = next;
        }
         if(!stack.isEmpty()) {
             newCurr.next = stack.pop();
         }
    }
}
