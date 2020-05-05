package com.nal.leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by nishant on 09/02/20.
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Example:
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

//O(NLogK) - N - Total number of nodes in the final output, K - total number of List
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
//        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(s -> s.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                q.offer(lists[i]);
        }
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null)
                q.offer(node.next);
        }
        return dummy.next;
    }
}
