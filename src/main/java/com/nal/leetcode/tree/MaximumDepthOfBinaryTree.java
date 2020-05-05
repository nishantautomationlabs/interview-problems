package com.nal.leetcode.tree;

import com.nal.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 10/02/20.
 * 104. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepthIterative(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int height = 0;
        while (!q.isEmpty()) {
            height++;
            for (int i = q.size() - 1; i >= 0; i--) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        return height;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
