package com.minhld.tree.questions;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree extends Thread {
    public void run() {
        Integer[] samples = { 1, 3, null, null, 2 };
        TreeNode root = Utils.buildTree(samples);
        recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        TreeNode c = root;
        List<TreeNode> list = new ArrayList<>();
        fetch(c, list);
        fix(list);
    }

    void fetch(TreeNode c, List<TreeNode> list) {
        if (c == null) return;
        fetch(c.left, list);
        list.add(c);
        fetch(c.right, list);
    }

    void fix(List<TreeNode> list) {
        int i = list.size() - 1;
        while (i > 0) {
            if (list.get(i - 1).val > list.get(i).val) {
                TreeNode c = list.get(i);
                while (i > 0 && list.get(i - 1).val > c.val) i--;
                int temp = c.val;
                c.val = list.get(i).val;
                list.get(i).val = temp;
                return;
            }
            i--;
        }
    }

    public static void main(String[] args) {
        new RecoverBinarySearchTree().start();
    }
}
