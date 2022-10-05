package com.stacks;

public class MinStackExample {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(18);
        System.out.println(stack.minElement());
        stack.push(19);
        System.out.println(stack.minElement());
        stack.push(29);
        System.out.println(stack.minElement());
        stack.push(15);
        System.out.println(stack.minElement());
        stack.push(15);
        System.out.println(stack.minElement());
        stack.push(16);
        System.out.println(stack.minElement());
    }
}
