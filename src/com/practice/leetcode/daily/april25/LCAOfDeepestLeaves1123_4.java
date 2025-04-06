package com.practice.leetcode.daily.april25;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LCAOfDeepestLeaves1123_4 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // BFS + LCA : TC : O(N) + O(N) : each node is visited once
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            while (size-- > 0 ) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result.add(list);
        }
        List<Integer> list = result.get(result.size()-1);
        if (list.size() == 1) return new TreeNode(list.get(0));

        return lca(root, list.get(0), list.get(list.size()-1));
    }

    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q)
            return root;

        TreeNode left = lca(root.left, p , q);
        TreeNode right = lca(root.right, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    // height + dfs TC : O(N^2)
    public TreeNode lcaDeepestLeavesDFs(TreeNode root) {
        if (root == null) return root;

        int lheight = getHeight(root.left);
        int rheight = getHeight(root.right);

        if (lheight == rheight) return root;
        else if (lheight > rheight) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        else return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
