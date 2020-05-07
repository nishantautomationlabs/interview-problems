package com.nal.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nishant on 03/02/20.
 * 144. Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 */
public class BTPreOrderTraversal {

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr == null) {
                TreeNode node = stack.pop();
                curr = node.right;
            } else {
                result.add(curr.data);
                stack.push(curr);
                curr = curr.left;
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.data);
        preorder(root.left, result);
        preorder(root.right, result);
    }

}
