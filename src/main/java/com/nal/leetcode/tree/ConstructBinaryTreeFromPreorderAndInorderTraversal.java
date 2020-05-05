package com.nal.leetcode.tree;

import com.nal.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nishant on 11/02/20.
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map) {
        if (pStart > pEnd || iStart > iEnd)
            return null;
        TreeNode node = new TreeNode(preorder[pStart]);
        int pos = map.get(preorder[pStart]);
        node.left = buildTree(preorder, pStart + 1, pStart + pos - iStart, inorder, iStart, pos - 1, map);  //pos - iStart is the no of nodes in the left sub-tree
        node.right = buildTree(preorder, pStart + pos - iStart + 1, pEnd, inorder, pos + 1, iEnd, map);
        return node;
    }
}
