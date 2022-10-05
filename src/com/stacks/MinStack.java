package com.stacks;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int num) {
        stack.push(num);
        if(minStack.empty() || num <= minStack.peek()) {
            minStack.push(num);
        }
    }

    public int pop() {
        if(!stack.empty()) {
            int num = stack.pop();
            if(num == minStack.peek()) {
                minStack.pop();
                return num;
            }
        }
        return -1;
    }

    public int minElement() {
        if(!minStack.empty())
            return minStack.peek();
        return -1;
    }
}
