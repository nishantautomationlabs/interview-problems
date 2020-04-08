package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 04/02/20.
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
