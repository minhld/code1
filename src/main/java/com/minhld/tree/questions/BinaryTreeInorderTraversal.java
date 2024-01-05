package com.minhld.tree.questions;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) return out;
        if (root.left != null) {
            out.addAll(inorderTraversal(root.left));
        }
        out.add(root.val);
        if (root.right != null) {
            out.addAll(inorderTraversal(root.right));
        }
        return out;
    }
}
