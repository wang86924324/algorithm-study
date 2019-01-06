package com.vincent.algorithm.tree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // p和q在左边
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        // p和q在右边
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lc2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            else {
                return root;
            }
        }

        return null;
    }
}
