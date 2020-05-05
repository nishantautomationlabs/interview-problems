package com.nal.leetcode.tree;

import com.nal.TreeNode;

/**
 * Created by nishant on 03/02/20.
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
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
