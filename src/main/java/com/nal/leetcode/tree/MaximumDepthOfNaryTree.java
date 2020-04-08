package com.nal.leetcode.tree;

import java.util.List;

/**
 * Created by nishant on 29/03/20.
 * 559. Maximum Depth of N-ary Tree
 * Given a n-ary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 */
public class MaximumDepthOfNaryTree {
    class Node {
        public int val;
        public List<Node> children;
    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int maxValue = 0;
        for (Node child : root.children) {
            maxValue = Math.max(maxValue, maxDepth(child));
        }
        return maxValue + 1;
    }
}
