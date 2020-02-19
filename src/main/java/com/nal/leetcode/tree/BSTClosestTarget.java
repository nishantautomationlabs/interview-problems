package com.nal.leetcode.tree;

import com.nal.datastructures.trees.TreeNode;

/**
 * Created by nishant on 04/02/20.
 */
public class BSTClosestTarget {

    public int closestValue(TreeNode root, double target) {
        if (root == null)
            return -1;
        int res = root.data;
        while (root != null) {
            if (Math.abs(target - root.data) < Math.abs(target - res))
                res = root.data;
            if (target < root.data)
                root = root.left;
            else
                root = root.right;
        }
        return res;
    }
}
