package com.vincent.algorithm.tree;

public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // terminator 只要有一个就返回
        if (root == null || root == p || root == q) {
            return root;
        }
        // drill down
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // process  两边都有，那么祖先是root。一方为null，祖先就是另一个节点
        return left == null ? right : (right == null ? left : root);
        // clear state

    }


    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //  terminator
        if (root == null || p == root || q == root) {
            return root;
        }

        // drill down
        TreeNode left = commonAncestor(root.left, p, q);
        TreeNode right = commonAncestor(root.right, p, q);

        // process
        return left == null ? right : (right == null ? left : root);
    }




}
