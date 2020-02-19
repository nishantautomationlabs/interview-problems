package com.nal.leetcode.tree;

import com.nal.datastructures.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nishant on 03/02/20.
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
