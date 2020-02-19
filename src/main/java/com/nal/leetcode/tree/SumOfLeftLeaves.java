package com.nal.leetcode.tree;

import com.nal.datastructures.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 10/02/20.
 * 404. Sum of Left Leaves
 * Find the sum of all left leaves in a given binary tree.
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeavesIterative(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null && node.left.left == null && node.left.right == null)
                sum += node.left.data;
            else if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
        return sum;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            return root.left.data + sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
