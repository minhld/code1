package com.minhld.tree.questions;

public class SameTree extends Thread {
    public void run() {
        Integer[] p = new Integer[] { 1 };
        Integer[] q = new Integer[] { 1, null, 2 };
        System.out.println("res = " + isSameTree(Utils.buildTree(p), Utils.buildTree(q)));
    }

    public static void main(String[] args) {
        new SameTree().start();
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Integer total = 0;
        checkSame(p, q, total);
        return total == 0;
    }

    public void checkSame(TreeNode p, TreeNode q, int total) {
        if (p != null) {
            if (q == null) total += -1;
            if (q != null) {
                total += (p.val != q.val ? -1 : 0);
                checkSame(p.left, q.left, total);
                checkSame(p.right, q.right, total);
            }
        } else {
            if (q == null) total += 0;
            if (q != null) total += -1;
        }
    }
}
