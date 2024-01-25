package com.minhld.tree.questions;

import java.util.*;

public class CousinsInBinaryTree2 extends Thread {
    public void run() {
        Map<String, List<String>> map = new IdentityHashMap<>();
        map.computeIfAbsent("hello", v -> new ArrayList<>()).add("no_1");
        map.computeIfAbsent("hello", v -> new ArrayList<>()).add("no_2");
        List<String> values = map.get("hello");
        values.add("no_3");
        System.out.println(map.putIfAbsent("hello", values));
        System.out.println(map);
    }

    public static void main(String[] args) {
        new CousinsInBinaryTree2().start();
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode c = root;
        queue.add(c);
        c.val = 0;
        int count = 0, total = 0, subTotal = 0;
        Map<TreeNode, List<TreeNode>> map;
        Map<TreeNode, Integer> totalMap;
        List<TreeNode> list;
        while (!queue.isEmpty()) {
            count = queue.size();
            map = new IdentityHashMap<>();
            totalMap = new IdentityHashMap<>();
            total = 0;
            while (count-- > 0) {
                c = queue.poll();
                if (c.left != null) {
                    queue.add(c.left);
                    total += c.left.val;
                    map.computeIfAbsent(c, v -> new ArrayList<>()).add(c.left);
                    totalMap.put(c, totalMap.getOrDefault(c, 0) + c.left.val);
                }
                if (c.right != null) {
                    queue.add(c.right);
                    total += c.right.val;
                    map.computeIfAbsent(c, v -> new ArrayList<>()).add(c.right);
                    totalMap.put(c, totalMap.getOrDefault(c, 0) + c.right.val);
                }
            }
            for (TreeNode key : map.keySet()) {
                list = map.get(key);
                subTotal = totalMap.get(key);
                for (TreeNode treeNode : list) {
                    treeNode.val = subTotal < total ? total - subTotal : 0;
                }
            }
        }
        return root;
    }
}
