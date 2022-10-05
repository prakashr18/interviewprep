package com.realinterview;

public class Solution3 {

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr= head;
        return reverseListHelper(curr, prev);

    }

    public static ListNode reverseListHelper(ListNode curr, ListNode prev) {
        if(curr == null) {
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        return reverseListHelper(next, curr);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5, null);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);
        System.out.println(reverseLinkedList(node5));
    }
}


