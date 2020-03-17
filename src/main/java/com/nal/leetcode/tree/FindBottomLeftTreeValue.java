package com.nal.leetcode.tree;

import com.nal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 09/03/20.
 * 513. Find Bottom Left Tree Value
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * Example 1:
 * Input:
 * 2
 * / \
 * 1   3
 * Output:
 * 1
 */
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null)
                queue.offer(node.right);
            if (node.left != null)
                queue.offer(node.left);
        }
        return node.data;
    }
}
