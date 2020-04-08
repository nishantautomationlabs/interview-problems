package com.nal.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by nishant on 18/03/20.
 * 1019. Next Greater Node In Linked List
 * We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.
 * Example 1:
 * Input: [2,1,5]
 * Output: [5,5,0]
 */
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null)
            return null;

        ArrayList<Integer> llArray = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            llArray.add(curr.val);
            curr = curr.next;
        }

        int[] result = new int[llArray.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < llArray.size(); i++) {
            while (!stack.isEmpty() && llArray.get(stack.peek()) < llArray.get(i)) {
                result[stack.pop()] = llArray.get(i);
            }
            stack.push(i);
        }
        return result;
    }
}
