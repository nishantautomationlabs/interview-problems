package com.nal.leetcode.tree;

import com.nal.TreeNode;

import java.util.Stack;

/**
 * Created by nishant on 09/03/20.
 * 938. Range Sum of BST
 * Given the root node of a binary search tree, return the sum of dataues of all nodes with dataue between L and R (inclusive).
 * The binary search tree is guaranteed to have unique dataues.
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 */
public class RangeSumOfBST {

    public int rangeSumBSTIterative(TreeNode root, int L, int R) {
        if (root == null)
            return 0;

        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.data >= L && node.data <= R)
                result += node.data;

            if (node.left != null && node.data > L) {
                stack.push(node.left);
            }
            if (node.right != null && node.data < R) {
                stack.push(node.right);
            }
        }

        return result;
    }

    public int rangeSumBSTRecursive(TreeNode root, int L, int R) {
        if (root == null)
            return 0;

        int result = 0;
        result = rangeSum(root, L, R, result);
        return result;
    }

    private int rangeSum(TreeNode root, int L, int R, int result) {
        if (root == null)
            return result;
        if (root.data >= L && root.data <= R)
            result += root.data;

        if (root.data > L) {
            result = rangeSum(root.left, L, R, result);
        }
        if (root.data < R) {
            result = rangeSum(root.right, L, R, result);
        }
        return result;
    }
}
