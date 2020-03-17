package com.nal.leetcode.tree;

import com.nal.TreeNode;

/**
 * Created by nishant on 09/03/20.
 * 965. Unidataued Binary Tree
 * A binary tree is unidataued if every node in the tree has the same dataue.
 * Return true if and only if the given tree is unidataued.
 * Example 1:
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
            return true;

        return isUnivalTree(root.left, root.data) && isUnivalTree(root.right, root.data);
    }

    private boolean isUnivalTree(TreeNode node, int val) {
        if(node == null)
            return true;

        return (node.data == val) && isUnivalTree(node.left, val) && isUnivalTree(node.right, val);
    }
}
