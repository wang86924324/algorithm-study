package com.vincent.algorithm.tree;


public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //  递归思路：
    // 假设已经有了最小值和最大值，那么当前节点一定要在这个范围内。递归的做这个判断。
    public boolean isValidBST(TreeNode node, Integer minVal, Integer maxVal) {
        // terminator
        if (node == null) return true;
        if (minVal != null && node.val <= minVal) return false;
        if (maxVal != null && node.val >= maxVal) return false;
        return isValidBST(node.left, minVal, node.val) && isValidBST(node.right, node.val, maxVal);
    }


    // 第一次层min和max为null
    // 第二层root节点作为左子树的max，作为有字数的min
    // 最左边的一条递归路线：只需要保证比最外层的min小即Root节点小。
    public boolean isValidBST3(TreeNode root, Integer min, Integer max) {
        // terminator
        if (root == null) return true;
        if (min != null && min >= root.val) return false;
        if (max != null && max <= root.val) return false;

        return isValidBST3(root.left, min, root.val) && isValidBST3(root.right, root.val, max);
    }

    public boolean isVaidBST4(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return isVaidBST4(root.left, min, root.val) && isVaidBST4(root.right, root.val, max);
    }
}
