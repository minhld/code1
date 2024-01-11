package com.minhld.tree.questions;

import java.util.Stack;

public class BSTIteratorTest extends Thread {
    public void run() {
        BSTIterator bts = new BSTIterator(null);
    }

    class BSTIterator {
        TreeNode p, r;
        Stack<TreeNode> s;

        public BSTIterator(TreeNode root) {
            s = new Stack<>();
            p = null;
            r = root;
        }

        public int next() {
            if (p == null) {
                p = r;
                moveLeft();
            } else if (p.left != null) {
                moveLeft();
            } else if (p.right != null) {
                p = p.right;
                moveLeft();
            } else if (!s.isEmpty()) {
                p = s.pop();
            }
            return p.val;
        }

        private void moveLeft() {
            TreeNode l;
            while (p.left != null) {
                l = p.left;
                p.left = null;
                s.push(p);
                p = l;
            }
        }

        public boolean hasNext() {
            if (p == null && r != null) return true;
            if (p.left == null && p.right == null && s.isEmpty()) return false;
            return (p.right != null || !s.isEmpty());
        }
    }

    public static void main(String[] args) {
        new BSTIteratorTest().start();
    }
}
