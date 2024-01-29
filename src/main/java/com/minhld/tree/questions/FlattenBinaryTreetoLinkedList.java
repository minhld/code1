package com.minhld.tree.questions;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode list = new TreeNode(root.val);
        TreeNode head = list;
        traverse(root, list);
        root.left = null;
        while (head != null) {
            System.out.print(head.val + " ");
            // root.right = head.right;
            // root = root.right;
            head = head.right;
        }
    }

    private void traverse(TreeNode c, TreeNode list) {
        if (c == null) return;
        list.left = null;
        list.right = new TreeNode(c.val);
        System.out.println(list.val);
        if (c.left != null) {
            traverse(c.left, list.right);
        }
        if (c.right != null) {
            traverse(c.right, list.right);
        }
    }
}
