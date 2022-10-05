package com.stacks;

public class RainWaterTrapping {

    public static void main(String[] args) {
        int[] arr = {3,0,0,2,0,4};
        int sum = rainWaterTrapping(arr);
        System.out.println("sum: "+sum);
    }

    public static int rainWaterTrapping(int[] arr) {
        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;

        for(int i=0, j=arr.length-1; i< arr.length; i++,j--) {
            leftArr[i] = Math.max(leftMax, arr[i]);
            rightArr[j] = Math.max(rightMax, arr[j]);
            leftMax = leftArr[i];
            rightMax = rightArr[j];
        }

        int sum =0;
        for(int i=0; i< arr.length; i++) {
            sum += Math.min(leftArr[i], rightArr[i]) - arr[i];
        }
        return sum;
    }
}
