package com.nal.leetcode;

import java.util.Stack;

/**
 * Created by nishant on 04/02/20.
 */
public class QueueUsingStacks {

    Stack<Integer> newestStack;
    Stack<Integer> oldestStack;

    /**
     * Initialize your data structure here.
     */
    public QueueUsingStacks() {
        newestStack = new Stack<>();
        oldestStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        newestStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        shiftStacks();
        return oldestStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        shiftStacks();
        return oldestStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return newestStack.isEmpty() && oldestStack.isEmpty();
    }

    private void shiftStacks() {
        if (oldestStack.isEmpty()) {
            while (!newestStack.isEmpty())
                oldestStack.push(newestStack.pop());
        }
    }
}
