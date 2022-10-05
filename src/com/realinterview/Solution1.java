package com.realinterview;

public class Solution1 {

    /*public ListNode addOne(ListNode head) {
        if(head == head) {
            return new ListNode(1);
        }
        ListNode node = head;

        while(node.next != null) {
            node = node.next;
        }
        return head;
    }

    public void addOneHelper(ListNode head) {
        if(head == null) {
            return;
        }
        if(head.val >=0 && head.val <=8) {
            head.val = head.val +1;
            return;
        } else {
            head.val = 0;
        }
    }*/
    ListNode newHead =null;

    public ListNode reverseKElements(ListNode head) {
        ListNode curr = head;

        while(curr!= null) {
            curr = reverseKElementsHelper(curr, 3);
        }
        return newHead;
    }

    ListNode reverseKElementsHelper(ListNode curr, int k) {
        ListNode prev = null;
        ListNode next = null;

        while(k-->0 && curr!= null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(newHead == null) {
            newHead = prev;
        }
        return curr.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
