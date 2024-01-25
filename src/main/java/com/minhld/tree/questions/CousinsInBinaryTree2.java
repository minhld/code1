package com.minhld.tree.questions;

import java.util.*;

public class CousinsInBinaryTree2 {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = null, c = root;
        queue.add(c);
        c.val = 0;
        int count = 0;
        Map<TreeNode, List<TreeNode>> map;
        while (!queue.isEmpty()) {
            count = queue.size();
            while (count > 0) {
                map = new IdentityHashMap<>();
                c = queue.poll();
                if (c == null) continue;
                if (c.left != null) {
                    queue.add(c.left);
                    map.computeIfAbsent(c, v -> new ArrayList<>())
                            .add(c.left);
                }
                if (c.right != null) {
                    queue.add(c.right);
                    map.computeIfAbsent(c, v -> new ArrayList<>())
                            .add(c.right);
                }
                System.out.print(c);
                count--;
            }
        }
        return root;
    }
}
