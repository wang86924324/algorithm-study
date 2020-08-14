package com.vincent.algorithm.tree;

public class Solution104 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        // divide and conquer
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public int maxDepth(TreeNode node) {
        return node == null ? 0 : Math.max(maxDepth(node.left), maxDepth(node.right));
    }


}
