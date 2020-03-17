package com.nal.leetcode.tree;

import com.nal.TreeNode;

/**
 * Created by nishant on 09/03/20.
 * 979. Distribute Coins in Binary Tree
 * Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)
 * Return the number of moves required to make every node have exactly one coin.
 * Example 1:
 * Input: [3,0,0]
 * Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
 */
public class DistributeCoinsInBinaryTree {

    int moves_count = 0;

    public int distributeCoins(TreeNode root) {
        if (root == null)
            return 0;

        int result = 0;
        calculateCoins(root);
        return moves_count;
    }

    public int calculateCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = calculateCoins(root.left);
        int right = calculateCoins(root.right);
        moves_count += Math.abs(left) + Math.abs(right);
        return root.data + left + right - 1;
    }
}
