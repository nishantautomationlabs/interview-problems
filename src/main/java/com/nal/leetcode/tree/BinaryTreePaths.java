package com.nal.leetcode.tree;

import com.nal.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 29/03/20.
 * 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 * Example:
 * Input:
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * Output: ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        getAllPaths(root, "", result);
        return result;
    }

    private void getAllPaths(TreeNode node, String path, List<String> result) {
        path += Integer.toString(node.data);
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            path = path + "->";
            if (node.left != null)
                getAllPaths(node.left, path, result);
            if (node.right != null)
                getAllPaths(node.right, path, result);
        }
    }
}
