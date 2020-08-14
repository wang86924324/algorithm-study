package com.vincent.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            res.add(currLevel);
        }

        return res;
    }

    public void _dfs(List<List<Integer>> result, TreeNode node, int level) {
        // terminator
        if (node == null) return;

        // process
        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        // drill down
        _dfs(result, node.left, level + 1);
        _dfs(result, node.right, level + 1);
    }
}
