package com.nal.leetcode.linkedlist;

import com.nal.leetcode.linkedlist.ListNode;

import java.util.Stack;

/**
 * Created by nishant on 03/02/20.
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode head = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();
            ListNode newNode = new ListNode(sum % 10);
            sum = sum / 10;
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }
        if (sum > 0) {
            ListNode newNode = new ListNode(sum);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}
