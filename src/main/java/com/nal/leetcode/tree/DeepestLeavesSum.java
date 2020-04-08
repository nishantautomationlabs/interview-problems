package com.nal.leetcode.tree;

import com.nal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 29/03/20.
 * 1302. Deepest Leaves Sum
 * Given a binary tree, return the sum of values of its deepest leaves.
 * Example 1:
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                sum += node.data;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return sum;
    }
}
