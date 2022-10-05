package com.binarytree;

import java.util.*;

public class Codec {
    private static final String spliter = ",";
    private static final String NULL = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if(root == null)
            sb.append(NULL).append(spliter);
        else {
            sb.append(root.val).append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    public TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if(val.equals(NULL))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public static void flatten(TreeNode root) {
        if(root ==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);

            }

            if(prev != null) {
                prev.right = node;
                prev.left =null;
            }
            prev = node;
        }
    }

    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(new TreeNode(5)));
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2,node1,node2);
        TreeNode node5 = new TreeNode(5,null,node3);
        TreeNode node6 = new TreeNode(1,node4,node5);
        flatten(node6);
        Queue<Integer> queue = new PriorityQueue<>(10, (o1, o2) -> {
            if(o1>o2) return -1;
            else if(o1<o2) return 1;
            else return 0;
        });
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {this.val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
