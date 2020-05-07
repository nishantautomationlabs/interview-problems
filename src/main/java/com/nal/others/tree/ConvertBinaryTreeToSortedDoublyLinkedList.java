package com.nal.others.tree;

import java.util.Stack;

/**
 * Created by nishant on 09/03/20.
 * 1534. Convert Binary Search Tree to Sorted Doubly Linked List
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
 */
public class ConvertBinaryTreeToSortedDoublyLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);

        TreeNode head = convertBTToLL(root);
        while (head != null) {
            System.out.print(head.data + "-->");
            head = head.right;
        }
    }

    private static TreeNode convertBTToLL(TreeNode root) {
        if (root == null)
            return null;

        TreeNode head = null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (prev == null) {
                    head = curr;
                    curr.left = null;
                } else {
                    prev.right = curr;
                    curr.left = prev;
                }
                prev = curr;
                curr = curr.right;
            }
        }
        prev.right = null;
        return head;
    }
}
