package com.nal.leetcode;

import com.nal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 03/02/20.
 */
public class SymmetricTree {

    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if (n1 == null && n2 == null)
                continue;
            if (n1 == null || n2 == null)
                return false;
            if (n1.data != n2.data)
                return false;
            q1.add(n1.left);
            q1.add(n1.right);
            q2.add(n2.right);
            q2.add(n2.left);
        }
        return true;
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null)
            return true;

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.data != node2.data)
            return false;
        else
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
}
