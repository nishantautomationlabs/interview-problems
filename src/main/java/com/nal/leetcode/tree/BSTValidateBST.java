package com.nal.leetcode.tree;

import com.nal.TreeNode;

import java.util.Stack;

/**
 * Created by nishant on 02/02/20.
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class BSTValidateBST {

    public boolean isValidBSTIterative(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr == null) {
                curr = stack.pop();
                if (prev != null && curr.data <= prev.data)
                    return false;
                prev = curr;
                curr = curr.right;
            } else {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validateBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
    }
}
