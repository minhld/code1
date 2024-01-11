package com.minhld.tree.questions;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    private int sum(TreeNode n, boolean isLeft) {
        if (n.left == null && n.right == null && isLeft) return n.val;
        int total = 0;
        if (n.left != null) {
            total += sum(n.left, true);
        }
        if (n.right != null) {
            total += sum(n.right, false);
        }
        return total;
    }
}
