package com.nal.leetcode.tree;

import com.nal.datastructures.trees.TreeNode;

/**
 * Created by nishant on 03/02/20.
 */
public class BSTLowestCommonAncestor {

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        TreeNode curr = root;
        while (curr != null) {
            if (p.data < curr.data && q.data < curr.data)
                curr = curr.left;
            else if (p.data > curr.data && q.data > curr.data)
                curr = curr.right;
            else
                break;
        }
        return curr;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.data < root.data && q.data < root.data)
            return lowestCommonAncestor(root.left, p, q);
        if (p.data > root.data && q.data > root.data)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
