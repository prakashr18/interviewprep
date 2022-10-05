package com.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static final void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        distinctList(node1);
    }

    public static ListNode distinctList(ListNode head) {
        if(head == null) return head;
        ListNode node = head;
        Map<Integer, Integer> map = new HashMap<>();
        while(node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) +1);
            node = node.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        ListNode curr = head;
        while(curr != null) {
            if(map.get(curr.val) ==1 ) {
                newHead.next  = curr;
                newHead = newHead.next;
                curr = curr.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode( int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    class Solution5 {
        private  final Scanner INPUT_READER = new Scanner(System.in);
        private  final DigitalWalletTransaction DIGITAL_WALLET_TRANSACTION = new DigitalWalletTransaction();

        private  final Map<String, DigitalWallet> DIGITAL_WALLETS = new HashMap<>();

        public  void main(String[] args) {
            int numberOfWallets = Integer.parseInt(INPUT_READER.nextLine());
            while (numberOfWallets-- > 0) {
                String[] wallet = INPUT_READER.nextLine().split(" ");
                DigitalWallet digitalWallet;

                if (wallet.length == 2) {
                    digitalWallet = new DigitalWallet(wallet[0], wallet[1]);
                } else {
                    digitalWallet = new DigitalWallet(wallet[0], wallet[1], wallet[2]);
                }

                DIGITAL_WALLETS.put(wallet[0], digitalWallet);
            }

            int numberOfTransactions = Integer.parseInt(INPUT_READER.nextLine());
            while (numberOfTransactions-- > 0) {
                String[] transaction = INPUT_READER.nextLine().split(" ");
                DigitalWallet digitalWallet = DIGITAL_WALLETS.get(transaction[0]);

                if (transaction[1].equals("add")) {
                    try {
                        DIGITAL_WALLET_TRANSACTION.addMoney(digitalWallet, Integer.parseInt(transaction[2]));
                        System.out.println("Wallet successfully credited.");
                    } catch (TransactionException ex) {
                        System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                    }
                } else {
                    try {
                        DIGITAL_WALLET_TRANSACTION.payMoney(digitalWallet, Integer.parseInt(transaction[2]));
                        System.out.println("Wallet successfully debited.");
                    } catch (TransactionException ex) {
                        System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                    }
                }
            }

            System.out.println();

            DIGITAL_WALLETS.keySet()
                    .stream()
                    .sorted()
                    .map((digitalWalletId) -> DIGITAL_WALLETS.get(digitalWalletId))
                    .forEachOrdered((digitalWallet) -> {
                        System.out.println(digitalWallet.getWalletId()
                                + " " + digitalWallet.getUsername()
                                + " " + digitalWallet.getWalletBalance());
                    });
        }
    }
}
