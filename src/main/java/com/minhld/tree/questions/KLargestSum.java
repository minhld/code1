package com.minhld.tree.questions;

import java.util.*;
import java.util.stream.Collectors;

public class KLargestSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> levelTotals = new ArrayList<>();
        TreeNode c = root;
        queue.add(c);
        int count = 0, total;
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
            levelTotals.add(total);
        }
        Integer[] sort = levelTotals.toArray(new Integer[] { });
        Arrays.sort(sort);
        return sort.length > k ? sort[sort.length - k] : -1;
    }
}
