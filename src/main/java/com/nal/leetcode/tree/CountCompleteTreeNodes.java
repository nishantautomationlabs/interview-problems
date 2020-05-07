package com.nal.leetcode.tree;

/**
 * Created by nishant on 11/02/20.
 * 222. Count Complete Tree Nodes
 * Given a complete binary tree, count the number of nodes.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int lHeight = 0, rHeight = 0;
        TreeNode leftNode = root, rightNode = root;
        while (leftNode != null) {
            lHeight++;
            leftNode = leftNode.left;
        }
        while (rightNode != null) {
            lHeight++;
            rightNode = rightNode.right;
        }
        if (lHeight == rHeight)
            return (int) Math.pow(2, lHeight) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
