package com.dp;

public class SubsetSumProblem {

    public static void main(String[] args) {
        int[] arr= {2,3,7,8,10};
        int sum =11;
        boolean isPresent = isSubsetSumPresent(arr,5, sum);
        System.out.println("isPresent: "+ isPresent);
    }

    public static boolean isSubsetSumPresent(int[] arr, int len, int sum) {
        boolean[][] matrix = new boolean[sum+1][len+1];

        for(int i=0; i< len; i++) {
            matrix[0][i] = true;
        }

        for(int i=1; i<=len; i++) {
            for(int j=1; j<=sum; j++) {
                if(arr[i-1] > j) {
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = matrix[i-1][j] || matrix[i-1][j-arr[i-1]];
                }
            }
        }

        return matrix[arr.length+1][sum+1];
    }
}
