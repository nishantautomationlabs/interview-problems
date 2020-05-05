package com.nal.leetcode.tree;


import com.nal.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 30/01/20.
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 * Example:
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        List<Integer> res = new ArrayList<>();
        pathSumUtil(root, sum, res, result);
        return result;
    }

    public void pathSumUtil(TreeNode root, int sum, List<Integer> res, List<List<Integer>> result)
    {
        if(root == null)
            return;

        res.add(root.data);
        if(root.left == null && root.right == null && root.data == sum)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(res);
            result.add(temp);
        }
        pathSumUtil(root.left, sum - root.data, res, result);
        pathSumUtil(root.right, sum - root.data, res, result);
        res.remove(res.size()-1);
    }
}
