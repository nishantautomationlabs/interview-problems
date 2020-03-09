package com.nal.leetcode.tree;

import com.nal.TreeNode;

/**
 * Created by nishant on 31/01/20.
 */
public class BTInvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
