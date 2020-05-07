package com.nal.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nishant on 06/04/20.
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        List<Integer> list = new ArrayList<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                list.add(node.data);
                if (node.left != null)
                    s2.add(node.left);
                if (node.right != null)
                    s2.add(node.right);
            }
            if (!list.isEmpty())
                result.add(new ArrayList<>(list));
            list.clear();
            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                list.add(node.data);
                if (node.right != null)
                    s1.add(node.right);
                if (node.left != null)
                    s1.add(node.left);
            }
            if (!list.isEmpty())
                result.add(new ArrayList<>(list));
            list.clear();
        }
        return result;
    }
}
