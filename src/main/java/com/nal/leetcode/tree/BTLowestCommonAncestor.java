package com.nal.leetcode.tree;

import com.nal.TreeNode;

/**
 * Created by nishant on 04/02/20.
 */
public class BTLowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        BTLowestCommonAncestor btLowestCommonAncestor = new BTLowestCommonAncestor();
        TreeNode treeNode = btLowestCommonAncestor.lowestCommonAncestor(root, root.left, new TreeNode(2));
        System.out.println("wait");
    }

    //Wont work if both the nodes are not present in the tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.data == p.data || root.data == q.data)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
