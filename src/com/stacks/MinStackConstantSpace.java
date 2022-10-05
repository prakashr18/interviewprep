package com.stacks;

import java.util.Stack;

public class MinStackConstantSpace {

    private Stack<Integer> stack;
    private int minElement;

    public MinStackConstantSpace() {
        this.stack = new Stack<>();
        this.minElement = 0;
    }

    public void push(int num) {
        if(stack.empty() || num>= minElement) {
            stack.push(num);
        } else {
            stack.push(num*2-minElement);
            minElement = num;
        }
    }

    public int pop() {
        if(!stack.empty() && stack.peek() >= minElement) {
            return stack.pop();
        } else if(!stack.empty()) {
            int num = minElement;
            minElement = minElement*2 - stack.pop();
        }
        return -1;
    }

    public int peek() {
        if(!stack.empty() && stack.peek() >= minElement)
            return stack.peek();
        else if(!stack.empty()) {
            return minElement;
        }
        return -1;
    }

    public int minimumElement() {
        if(!stack.empty())
            return minElement;
        return -1;
    }
}
