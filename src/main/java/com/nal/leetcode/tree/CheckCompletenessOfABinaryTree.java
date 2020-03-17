package com.nal.leetcode.tree;

import com.nal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 09/03/20.
 * 958. Check Completeness of a Binary Tree
 * Given a binary tree, determine if it is a complete binary tree.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * Example 1:
 * Input: [1,2,3,4,5,6]
 * Output: true
 */
public class CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean seen_null = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                seen_null = true;
            } else {
                if (seen_null)
                    return false;
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }
}