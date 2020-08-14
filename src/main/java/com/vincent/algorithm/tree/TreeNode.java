package com.vincent.algorithm.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public Integer val;

    private TreeNode getTree() {
        TreeNode root = new TreeNode();
        TreeNode result = root;
        root.val = 1;

        TreeNode left = new TreeNode();
        left.val = 2;

        TreeNode right = new TreeNode();
        right.val = 3;

        root.left = left;
        root.right = right;

        root = left;
        root.left = new TreeNode();
        root.left.val = 4;

        root.right = new TreeNode();
        root.right.val = 5;

        root = right;
        root.right = new TreeNode();
        root.right.val = 6;

        return result;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.dfs(treeNode.getTree());

        System.out.println("----------------");
        treeNode.dfsByStack(treeNode.getTree());

        System.out.println("-----------------");
        treeNode.queueSearch(treeNode.getTree());
    }


    private void dfs(TreeNode node) {
        // terminator
        if (node == null) {
            return;
        }

        // process
        System.out.println(node.val);

        // trill down
        dfs(node.left);
        dfs(node.right);
    }

    private void dfsByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }
    }

    private List<List<Integer>> queueSearch(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.pop();
                row.add(node.val);
                if (node.left != null) queue.push(node.left);
                if (node.right != null) queue.push(node.right);
            }
            result.add(row);
        }

        return result;
    }

    private void _dfs(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) _dfs(result, root.left, level + 1);
        if (root.right != null) _dfs(result, root.right, level + 1);
    }
}
