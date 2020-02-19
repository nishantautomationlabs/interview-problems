package com.nal.leetcode.tree;

import com.nal.datastructures.trees.TreeNode;

import java.util.Stack;

/**
 * Created by nishant on 02/02/20.
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

        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;

        return validateBST(root, min, max);
    }

    private boolean validateBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
    }
}
