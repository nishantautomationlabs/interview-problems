package com.nal.leetcode.tree;

import java.util.Stack;

/**
 * Created by nishant on 30/01/20.
 * 112. Path Sum
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 * Example:
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSumRecursive(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null && root.val == sum)
            return true;

        return hasPathSumRecursive(root.left, sum - root.val) || hasPathSumRecursive(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.left.left =new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        System.out.println(pathSum.hasPathSumIterative(treeNode, 22));
    }

    public boolean hasPathSumIterative(TreeNode root, int sum) {
        if (root == null)
            return false;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.push(root);
        sumStack.push(sum - root.val);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int value = sumStack.pop();
            if(node.left == null && node.right == null && value == 0)
                return true;

            if(node.left != null){
                stack.push(node.left);
                sumStack.push(value - node.left.val);
            }
            if(node.right != null) {
                stack.push(node.right);
                sumStack.push(value - node.right.val);
            }
        }
        return false;
    }
}
