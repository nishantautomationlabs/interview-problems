package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 04/02/20.
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {
            currA = currA != null ? currA.next : headB;
            currB = currB != null ? currB.next : headA;
        }
        return currA;
    }
}
