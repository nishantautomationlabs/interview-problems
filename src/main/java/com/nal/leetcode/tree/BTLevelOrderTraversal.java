package com.nal.leetcode.tree;

import com.nal.TreeNode;

import javax.swing.*;
import java.util.*;

/**
 * Created by nishant on 03/02/20.
 */
public class BTLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.data);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(new ArrayList<>(oneLevel));
        }
        return result;
    }
}
