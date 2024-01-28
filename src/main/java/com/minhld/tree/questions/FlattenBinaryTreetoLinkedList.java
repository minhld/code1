package com.minhld.tree.questions;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode list = new TreeNode(root.val);
        traverse(root, list);
        root = list;
    }

    private void traverse(TreeNode c, TreeNode list) {
        if (c == null) return;
        list.left = null;
        list.right = new TreeNode(c.val);
        if (c.left != null) {
            traverse(c.left, list.right);
        }
        if (c.right != null) {
            traverse(c.right, list.right);
        }
    }
}
