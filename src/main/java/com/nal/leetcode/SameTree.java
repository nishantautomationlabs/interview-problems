package com.nal.leetcode;

import com.nal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 05/02/20.
 */
public class SameTree {

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null)
                return false;
            if (node1.data != node2.data)
                return false;
            queue.add(node1.left);
            queue.add(node2.left);
            queue.add(node1.right);
            queue.add(node2.right);
        }
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.data != q.data)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
