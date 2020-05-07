package com.nal.leetcode.tree;

/**
 * Created by nishant on 29/03/20.
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int start, int end) {
        if (end < start)
            return null;

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createBST(nums, start, mid - 1);
        node.right = createBST(nums, mid + 1, end);
        return node;
    }
}
