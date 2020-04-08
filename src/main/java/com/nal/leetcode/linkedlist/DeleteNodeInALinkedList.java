package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 22/03/20.
 * 237. Delete Node in a Linked List
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * Example 1:
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
