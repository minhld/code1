package com.minhld.tree.questions;

import java.util.Stack;

public class RecoverBinarySearchTree extends Thread {
    public void run() {

    }

    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode c = root;
        compare(root, 0, Integer.MAX_VALUE);

    }

    void compare(TreeNode c, int min, int max) {
        if (c.left != null && c.left.val > max) {
            System.out.println(c.left.val);
        }
        if (c.right != null && c.right.val < min)
            if (c.left != null && c.val > c.left.val) {
                compare(c.left, c.left.val, max);
            }
        if (c.right != null && c.val < c.right.val) {
            compare(c.right, min, c.right.val);
        }
    }

    public static void main(String[] args) {
        new RecoverBinarySearchTree().start();
    }
}
