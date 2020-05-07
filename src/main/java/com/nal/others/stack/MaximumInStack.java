package com.nal.others.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by nishant on 10/01/20.
 * https://www.geeksforgeeks.org/find-maximum-in-a-stack-in-o1-time-and-o1-extra-space/
 * Find maximum in a stack in O(1) time and O(1) extra space
 * Given a stack of integers. The task is to design a special stack such that maximum element can be found in O(1) time and O(1) extra space.
 */
public class MaximumInStack {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaximumInStack() {
        this.stack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(Integer value) {
        stack.push(value);
        if (maxStack.isEmpty() || maxStack.peek() <= value) {
            maxStack.push(value);
        }
    }

    public Integer pop() {
        Integer value = stack.pop();
        System.out.println("Popped " + value);
        if (maxStack.peek() == value)
            maxStack.pop();
        return value;
    }

    public Integer getMax() {
        if(maxStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return maxStack.peek();
    }

    public void printStacks() {
        System.out.print("Stack is ");
        System.out.println(new ArrayList<>(stack).toString());
        System.out.print("Max Stack is ");
        System.out.println(new ArrayList<>(maxStack).toString());
    }

    public static void main(String[] args) {
        MaximumInStack maximumInStack = new MaximumInStack();
        maximumInStack.push(20);
        maximumInStack.push(30);
        maximumInStack.push(10);
        maximumInStack.push(40);
        maximumInStack.push(50);
        maximumInStack.push(5);
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
    }
}
