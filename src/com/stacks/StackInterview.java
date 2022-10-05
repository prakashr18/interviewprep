package com.stacks;

import java.util.Arrays;
import java.util.Stack;

public class StackInterview {

    public static void main(String[] args) {
        int[] arr = {100,80,60,70,150,60,75,85};
        Arrays.stream(arr).forEach((num) -> System.out.print(num +" "));
        System.out.println();
        System.out.println("Nearest Greater Element on Right");
        int[] result = nearestGreaterElementOnRight(arr);
        Arrays.stream(result).forEach((num) -> System.out.print(num +" "));
        System.out.println();
        System.out.println("Nearest Greater Element on left");
        int[] result1 = nearestGreaterElementOnLeft(arr);
        Arrays.stream(result1).forEach((num) -> System.out.print(num +" "));
        System.out.println();
        System.out.println("Nearest Smallest Element on left");
        int[] result2 = nearestSmallestElementOnLeft(arr);
        Arrays.stream(result2).forEach((num) -> System.out.print(num +" "));
        System.out.println();
        System.out.println("Nearest Smallest Element on Right");
        int[] result3 = nearestSmallestElementOnRight(arr);
        Arrays.stream(result3).forEach((num) -> System.out.print(num +" "));
        System.out.println();
        System.out.println("Stock Span Problem");
        int[] result4 = stockSpanProblem(arr);
        Arrays.stream(result4).forEach((num) -> System.out.print(num +" "));
        System.out.println();
        System.out.println("Next Greater Element-|| Problem");
        int[] result5 = nextGreaterElements(arr);
        Arrays.stream(result5).forEach((num) -> System.out.print(num +" "));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length, res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && num > nums[stack.peek()])
                res[stack.pop()] = num;
            stack.push(i % n);
        }
        return res;
    }

    /*
    To get nearest greater element to the current element on right in the array
     */
    public static int[] nearestGreaterElementOnRight(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length -1; i>=0; i--) {
            if(stack.empty()) {
                result[i] = -1;
            }
            else if(!stack.empty() && stack.peek() >arr[i]) {
                result[i] = stack.peek();
            }
            else {
                while(!stack.empty() && stack.peek() <=arr[i]) {
                    stack.pop();
                }
                if(stack.empty())
                    result[i] = -1;
                else
                    result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    /*
    To get nearest greater element to the current element on left in the array
     */
    public static int[] nearestGreaterElementOnLeft(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< arr.length; i++) {
            if(stack.empty()) {
                result[i] = -1;
            }
            else if(!stack.empty() && stack.peek() > arr[i]) {
                result[i] = stack.peek();
            }
            else {
                while(!stack.empty() && stack.peek() <=arr[i]) {
                    stack.pop();
                }
                if(stack.empty())
                    result[i] = -1;
                else
                    result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    /*
   To get nearest lesser element to the current element on left in the array
    */
    public static int[] nearestSmallestElementOnLeft(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< arr.length; i++) {
            if(stack.empty()) {
                result[i] = -1;
            }
            else if(!stack.empty() && stack.peek() < arr[i]) {
                result[i] = stack.peek();
            }
            else {
                while(!stack.empty() && stack.peek() >=arr[i]) {
                    stack.pop();
                }
                if(stack.empty())
                    result[i] = -1;
                else
                    result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    /*
    To get nearest smallest element to the current element on right in the array
     */
    public static int[] nearestSmallestElementOnRight(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length -1; i>=0; i--) {
            if(stack.empty()) {
                result[i] = -1;
            }
            else if(!stack.empty() && stack.peek() <arr[i]) {
                result[i] = stack.peek();
            }
            else {
                while(!stack.empty() && stack.peek() >=arr[i]) {
                    stack.pop();
                }
                if(stack.empty())
                    result[i] = -1;
                else
                    result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }


    /*
    To get nearest greater element to the current element on left in the array
     */
    public static int[] stockSpanProblem(int[] arr) {
        int[] result = new int[arr.length];
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i< arr.length; i++) {
            if(stack.empty()) {
                result[i] = -1;
            }
            else if(!stack.empty() && stack.peek()[0] > arr[i]) {
                result[i] = stack.peek()[1];
            }
            else {
                while(!stack.empty() && stack.peek()[0] <=arr[i]) {
                    stack.pop();
                }
                if(stack.empty())
                    result[i] = -1;
                else
                    result[i] = stack.peek()[1];
            }
            stack.push(new int[]{arr[i],i});
        }
        for(int i=0; i< result.length; i++) {
            System.out.print(result[i] + " ");
            result[i] = i - result[i];
        }
        System.out.println();
        return result;
    }
}
