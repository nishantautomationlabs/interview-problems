package com.nal.leetcode.tree;

import com.nal.TreeNode;

import java.util.HashMap;

/**
 * Created by nishant on 09/03/20.
 * 662. Maximum Width of Binary Tree
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        HashMap<Integer, Integer> leftMostElementIndexAtLevel = new HashMap<>();
        int maxWidth = findMaxWidth(root, 0, 1, leftMostElementIndexAtLevel, 0);
        return maxWidth;

    }

    private int findMaxWidth(TreeNode node, int level, int pos, HashMap<Integer, Integer> leftMostElementIndexAtLevel, int maxWidth) {
        leftMostElementIndexAtLevel.putIfAbsent(level, pos);
        maxWidth = Math.max(maxWidth, pos - leftMostElementIndexAtLevel.get(level) + 1);
        if (node.left != null)
            maxWidth = findMaxWidth(node.left, level + 1, pos * 2, leftMostElementIndexAtLevel, maxWidth);
        if (node.right != null)
            maxWidth = findMaxWidth(node.right, level + 1, (pos * 2) + 1, leftMostElementIndexAtLevel, maxWidth);
        return maxWidth;
    }
}
