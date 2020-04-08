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
public class LRUCache {

    HashMap<Integer, Integer> map;
    LinkedList<Integer>linkedList;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.linkedList = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        linkedList.removeFirstOccurrence(key);  //This is not in order of 1
        linkedList.addLast(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.size() == capacity && !map.containsKey(key)) {
            map.remove(linkedList.removeFirst());
        }
        map.put(key, value);
        linkedList.removeFirstOccurrence(key);
        linkedList.addLast(key);
    }
}
