package com.minhld.tree.questions;

import java.util.*;

public class CousinsInBinaryTree2 {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = null, c = root;
        queue.add(c);
        c.val = 0;
        int count = 0;
        Map<TreeNode, List<TreeNode>> map = new IdentityHashMap<>();
        while (!queue.isEmpty()) {
            count = queue.size();
            while (count > 0) {
                c = queue.poll();
                if (c == null) continue;
                if (c.left != null) {
                    queue.add(c.left);
                    map.computeIfAbsent(c.left,
                            v -> {
                                List<TreeNode> list = new ArrayList<>();
                                return list;
                            });
                }
                if (c.right != null) {
                    queue.add(c.right);
                }
                count--;
            }
        }
        return root;
    }
}
