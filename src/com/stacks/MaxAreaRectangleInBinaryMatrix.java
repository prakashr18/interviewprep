package com.stacks;

import java.util.*;

public class MaxAreaRectangleInBinaryMatrix {

    public static void main(String[] args) {
        int[] row1 = {0,1,1,0,0};
        int[] row2 = {1,1,1,1,1};
        int[] row3 = {1,1,1,1,1};
        int[] row4 = {1,1,0,0,1};
        int[][] matrix = {row1,row2,row3,row4};
        int maxRectArea = maxAreaRectangle(matrix);
        System.out.println("maxRectArea: " +maxRectArea);
    }

    public static int maxAreaRectangle(int[][] matrix) {
        int maxRectArea = Integer.MIN_VALUE;
        int[] row = new int[matrix[0].length];
        for(int i=0; i< matrix.length; i++) {
            for(int j=0; j< matrix[i].length; j++) {
                if(matrix[i][j] == 0 )
                    row[j] = 0;
                else
                    row[j] += matrix[i][j];
            }
            int area = maxAreaInEachrow(row);
            maxRectArea = Math.max(maxRectArea, area);
        }
        return maxRectArea;
    }

    public static int maxAreaInEachrow(int[] arr) {
        int max= Integer.MIN_VALUE;
        int[] left = nearestSmallestElementOnLeft(arr);
        int[] right = nearestSmallestElementOnRight(arr);
        for(int i=0; i< arr.length; i++) {
            max = Math.max(max, arr[i] * (right[i] - left[i] -1));
        }
        return max;
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
