package com.realinterview;

import java.util.LinkedList;
import java.util.Queue;

/*
              1
         2         3
    4   null     6    5
 */
public class Solution {

    public TreeNode pointNext(TreeNode root) {
        if(root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode prev = null;
            TreeNode curr = null;
            for(int i=0; i< size; ++i) {
                curr = queue.poll();
                if(prev != null) {
                    prev.next = curr;
                }
                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
                prev = curr;
            }
        }
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode() {
    }
}

