package com.nal.leetcode.tree;

import com.nal.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 29/03/20.
 * 501. Find Mode in Binary Search Tree
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 * 1
 * \
 * 2
 * /
 * 2
 * return [2].
 */
public class FindModeInBinarySearchTree {
    Integer prev = null;
    int count = 1;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];

        List<Integer> result = new ArrayList<>();
        findAllMode(root, result);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void findAllMode(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        findAllMode(node.left, result);
        if (prev != null) {
            if (node.data == prev) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            result.clear();
        }
        if (count == maxCount) {
            result.add(node.data);
        }

        prev = node.data;
        findAllMode(node.right, result);
    }
}
