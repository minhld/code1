package com.minhld.tree.questions;

public class CousinsBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] r1 = findNode(root, root, x, 0);
        int[] r2 = findNode(root, root, y, 0);
        return r1[0] == r2[0] && r1[1] != r2[1];
    }

    public int[] findNode(TreeNode c, TreeNode p, int val, int d) {
        if (c.val == val) {
            return new int[] { d, p.val };
        }
        int[] res = new int[] { -1, p.val };
        if (c.left != null) {
            res = findNode(c.left, c, val, d + 1);
            if (res[0] != -1) return res;
        }
        if (c.right != null) {
            res = findNode(c.right, c, val, d + 1);
            if (res[0] != -1) return res;
        }
        return res;
    }
}
