package com.vincent.algorithm.tree;

import sun.reflect.generics.tree.Tree;

import java.util.Queue;
import java.util.Stack;

public class _98ValidateBST {
    public static void main(String[] args) {

    }

    public boolean validate(TreeNode treeNode) {
        return validate(treeNode, null, null);
    }

    // 1.遍历排除法
    // 2.null不用排除，标识如果只有一个根节点，一定满足
    // 3.假设有子节点，那么满足根节点在两个节点之间即可。

    public boolean validate(TreeNode node, Integer min, Integer max) {
        // terminator
        if (node == null) {
            return true;
        }

        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;

        return validate(node.right, node.val, max) && validate(node.left, min, node.val);
    }

    public boolean validateNode(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val >= min) || (max != null && node.val <= max)) return false;

        return validateNode(node.left, min, node.val) && validateNode(node.right, node.val, max);

    }


}
