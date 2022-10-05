package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution1 {

    static class ListNode {
        int val;
        ListNode left;
        ListNode right;
        ListNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean symetricTree(ListNode root) {
        if(root == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.empty()) {
            ListNode left = stack.pop();
            ListNode right = stack.pop();

            if((left == null && right == null))
                continue;
            if(left == null || right == null || left.val != right.val) return false;

            stack.push(left.right);
            stack.push(right.left);
            stack.push(left.left);
            stack.push(right.right);
        }
        return true;
    }

    public static boolean isSymmetric(ListNode root) {
        if(root == null)
            return false;
        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(ListNode left, ListNode right) {
        if(left == null && right == null)
            return true;
        else if(left == null || right == null)
            return false;
        else {
            return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(5);
        ListNode node9 = new ListNode(3);
        ListNode node10 = new ListNode(5);
        ListNode node11 = new ListNode(5);
        ListNode node12 = new ListNode(5);
        ListNode node13 = new ListNode(5);
        ListNode node14 = new ListNode(5);
        ListNode node15 = new ListNode(3);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;
        node5.right = node11;

        node6.left = node12;
        node6.right = node14;

        node7.left = node15;
        node7.right = node13;

        boolean result = symetricTree(node1);
        System.out.println("Result: " +result);

    }
}
