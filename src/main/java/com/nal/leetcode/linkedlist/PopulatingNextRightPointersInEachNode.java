package com.nal.leetcode.linkedlist;

/**
 * Created by nishant on 10/02/20.
 * 116. Populating Next Right Pointers in Each Node
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 */
public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

    public Node connectRecursive(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return root;
        root.left.next = root.right;
        root.right.next = root.next == null ? null : root.next.left;
        connectRecursive(root.left);
        connectRecursive(root.right);
        return root;
    }

    public Node connectIterative(Node root) {
        Node leftNode = root;
        while (leftNode != null && leftNode.left != null) {
            connectNodesAtLevelBelow(leftNode);
            leftNode = leftNode.left;
        }
        return root;
    }

    private void connectNodesAtLevelBelow(Node node) {
        while (node != null) {
            node.left.next = node.right;
            if (node.next != null)
                node.right.next = node.next.left;
            node = node.next;
        }
    }
}
