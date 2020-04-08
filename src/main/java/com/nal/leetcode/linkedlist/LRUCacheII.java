package com.nal.leetcode.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by nishant on 28/03/20.
 * 146. LRU Cache
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * The cache is initialized with a positive capacity.
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */
public class LRUCacheII {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;
    }

    private int cacheCapacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;

    public LRUCacheII(int capacity) {
        cacheCapacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        removeNode(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cacheCapacity == map.size() && !map.containsKey(key)) {
            Node lastNode = tail.prev;
            map.remove(lastNode.key);
            removeNode(lastNode);
        } else if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        Node node = new Node();
        node.key = key;
        node.val = value;
        addToHead(node);
        map.put(key, node);
    }

    public void addToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private void removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }
}
