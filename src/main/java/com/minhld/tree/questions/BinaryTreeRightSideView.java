package com.minhld.tree.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode c = root;
        queue.add(c);
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size-- > 0) {
                c = queue.poll();
                if (size == 0) list.add(c.val);
                if (c.left != null) queue.add(c.left);
                if (c.right != null) queue.add(c.right);
            }
        }
        return list;
    }
}
