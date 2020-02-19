package com.nal.leetcode;

import com.nal.datastructures.trees.TreeNode;

/**
 * Created by nishant on 05/02/20.
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null || t2 == null)
            return t1 == null ? t2 : t1;

        t1.data += t2.data;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
