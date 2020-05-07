package com.nal.others.tree;

/**
 * Created by nishant on 04/02/20.
 * 900. Closest Binary Search Tree Value (LintCode)
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Input: root = {5,4,9,2,#,8,10} and target = 6.124780
 * Output: 5
 */
public class ClosestBinarySearchTreeValue {

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
