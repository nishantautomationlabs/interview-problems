package com.nal.leetcode;

import java.util.Stack;

/**
 * Created by nishant on 30/01/20.
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

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null && root.val == sum)
            return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.left.left =new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        System.out.println(pathSum.hasPathSum2(treeNode, 22));


    }

    public boolean hasPathSum2(TreeNode root, int sum) {
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
