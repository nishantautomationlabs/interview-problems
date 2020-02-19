package com.nal.leetcode.tree;

import com.nal.datastructures.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nishant on 01/02/20.
 */
public class BTZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        List<Integer> list = new ArrayList<>();
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            while(!s1.isEmpty())
            {
                TreeNode node = s1.pop();
                list.add(node.data);
                if(node.left != null)
                    s2.add(node.left);
                if(node.right != null)
                    s2.add(node.right);
            }
            if(!list.isEmpty())
                result.add(new ArrayList<>(list));
            list.clear();
            while(!s2.isEmpty())
            {
                TreeNode node = s2.pop();
                list.add(node.data);
                if(node.right != null)
                    s1.add(node.right);
                if(node.left != null)
                    s1.add(node.left);
            }
            if(!list.isEmpty())
                result.add(new ArrayList<>(list));
            list.clear();
        }
        return result;
    }
}
