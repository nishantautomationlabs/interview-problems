package com.nal.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nishant on 04/03/20.
 * 590. N-ary Tree Postorder Traversal
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 */


public class NaryTreePostorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorderIterative(Node root) {
        if (root == null)
            return new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        LinkedList<Integer> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.addFirst(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return new ArrayList<>(result);
    }

    public List<Integer> postorderRecursive(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        postorderHelperRecursive(root, result);
        return result;
    }

    private void postorderHelperRecursive(Node root, List<Integer> result) {
        if (root == null)
            return;
        for (Node child : root.children) {
            postorderHelperRecursive(child, result);
        }
        result.add(root.val);
    }
}
