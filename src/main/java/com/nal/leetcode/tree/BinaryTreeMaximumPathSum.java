package com.nal.leetcode.tree;

/**
 * Created by nishant on 28/03/20.
 * 124. Binary Tree Maximum Path Sum
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * Example 1:
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 */
public class BinaryTreeMaximumPathSum {
    private int max;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        max = Integer.MIN_VALUE;
        if (root.left == null && root.right == null) {
            return root.data;
        }
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, maxSum(node.left));
        int rightSum = Math.max(0, maxSum(node.right));
        max = Math.max(max, leftSum + rightSum + node.data);
        return Math.max(leftSum, rightSum) + node.data;
    }
}
