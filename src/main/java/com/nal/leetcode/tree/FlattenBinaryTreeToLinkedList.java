package com.nal.leetcode.tree;

import java.util.Stack;

/**
 * Created by nishant on 09/03/20.
 * 114. Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            node.left = null;
            if (!stack.isEmpty()) {
                node.right = stack.peek();
            }
        }
    }
}
