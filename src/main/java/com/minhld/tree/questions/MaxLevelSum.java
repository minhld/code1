package com.minhld.tree.questions;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode c = root;
        queue.add(c);
        int count = 1, total = 0, max = -1 * Integer.MAX_VALUE, level = 1, maxLevel = 1;
        while (!queue.isEmpty()) {
            count = queue.size();
            total = 0;
            while (count-- > 0) {
                c = queue.poll();
                total += c.val;
                if (c.left != null) {
                    queue.add(c.left);
                }
                if (c.right != null) {
                    queue.add(c.right);
                }
            }
            maxLevel = total > max ? level : maxLevel;
            max = Math.max(total, max);
            level++;
        }
        return maxLevel;
    }
}
