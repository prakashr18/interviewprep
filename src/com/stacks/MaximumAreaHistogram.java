package com.stacks;

import java.util.Arrays;
import java.util.Stack;

public class MaximumAreaHistogram {

    public static void main(String[] args) {
        //int[] arr = {100,80,60,70,150,60,75,85};
        int[] arr = {6,2,5,4,5,1,6};
        Arrays.stream(arr).forEach((num) -> System.out.print(num +" "));
        System.out.println();
        System.out.println("Nearest Smallest Element on left");
        int[] left = nearestSmallestElementOnLeft(arr);
        Arrays.stream(left).forEach((num) -> System.out.print(num +" "));
        System.out.println();
        System.out.println("Nearest Smallest Element on Right");
        int[] right = nearestSmallestElementOnRight(arr);
        Arrays.stream(right).forEach((num) -> System.out.print(num +" "));

        int[] width = new int[arr.length];

        for(int i=0; i< width.length; i++) {
            width[i] = right[i] - left[i] -1;
        }
        System.out.println();
        System.out.println("width array");
        Arrays.stream(width).forEach((num) -> System.out.print(num +" "));
        int[] area = new int[width.length];
        for(int i=0; i< area.length; i++) {
            area[i] = arr[i] * width[i] ;
        }
        System.out.println();
        System.out.println("area array");
        Arrays.stream(area).forEach((num) -> System.out.print(num +" "));
    }

    public static int[] nearestSmallestElementOnLeft(int[] arr) {
        int[] result = new int[arr.length];
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i< arr.length; i++) {
            if(stack.empty()) {
                result[i] = -1;
            } else if(!stack.empty() && stack.peek()[0] < arr[i]) {
                result[i] = stack.peek()[1];
            } else {
                while(!stack.empty() && stack.peek()[0] >= arr[i]) {
                    stack.pop();
                }
                if(stack.empty())
                    result[i] = -1;
                else
                    result[i] = stack.peek()[1];
            }
            stack.push(new int[]{arr[i], i});
        }
        return result;
    }

    public static int[] nearestSmallestElementOnRight(int[] arr) {
        int[] result = new int[arr.length];
        Stack<int[]> stack = new Stack<>();

        for(int i= arr.length-1; i>=0; i--) {
            if(stack.empty())
                result[i] = arr.length;
            else if(!stack.empty() && stack.peek()[0] < arr[i])
                result[i] = stack.peek()[1];
            else {
                while(!stack.empty() && stack.peek()[0] >= arr[i])
                    stack.pop();
                if(stack.empty())
                    result[i] = arr.length;
                else
                    result[i] = stack.peek()[1];
            }
            stack.push(new int[]{arr[i],i});
        }
        return result;
    }
}
