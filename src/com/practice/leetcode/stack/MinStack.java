package com.practice.leetcode.stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
        stack1.push(val);
        int min = stack2.isEmpty() || stack2.peek() > val ? val : stack2.peek();
        stack2.push(min);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
