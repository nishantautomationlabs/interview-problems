package com.nal.leetcode.tree;

/**
 * Created by nishant on 31/01/20.
 * 226. Invert Binary Tree
 * Invert a binary tree.
 * Example:
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class BTInvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
