package homework.week5;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {
//    public boolean isValidBST(TreeNode root) {
//        return helper(root, null, null);
//    }
//
//    private boolean helper(TreeNode root, Integer leftMax, Integer rightMin) {
//        if (root == null) return true;
//        if (leftMax != null && leftMax >= root.val) return false;
//        if (rightMin != null && rightMin <= root.val) return false;
//        return helper(root.left, leftMax, root.val) && helper(root.right, root.val, rightMin);
//    }

//    public void inorderTravel(TreeNode root) {
//        if (root == null) return;
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode node = root;
//        // node控制入栈   stack控制出站
//        while (node != null || !stack.isEmpty()) {
//            // 压入左子树
//            while (node != null) {
//                stack.push(node);
//                node = node.left;
//            }
//            // 弹出栈栈顶元素
//            node = stack.pop();
//            // 记录出站元素
//            System.out.println(node.val);
//            // 进入右子树
//            node = node.right;
//        }
//    }

    public void preorerTravel(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            // 压入左子树（记录入栈顺序）
            while (node != null) {
                stack.push(node);
                res.add(node.val);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
    }

    public void postorerTravel(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            // 压入左子树（记录入栈顺序）
            while (node != null) {
                stack.push(node);
                res.add(node.val);
                node = node.right;
            }
            node = stack.pop();
            node = node.left;


        }
    }


    // 理解方法：数学归纳法 假设有一个[1,2,3]的二叉树，我们保证出站顺序为1 2 3即可。
    // 前提：首先进栈的是1，首先出栈的也是1.
    // 那么接下来，需要把右节点3，和左节点2分别进站，才能保证2,3出站顺序。
    List<Integer> res = new ArrayList<>();

//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) return res;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            res.add(node.val);
//            if (node.right != null) stack.push(node.right);
//            if (node.left != null) stack.push(node.left);
//        }
//        return res;
//    }
//
//    public List<Integer> postorderTraversal(TreeNode root) {
//        if (root == null) return res;
//        Stack<TreeNode> s = new Stack<>();
//        while (!s.isEmpty()) {
//            TreeNode node = s.pop();
//            res.add(node.val);
//            if (node.left != null) s.push(node.left);
//            if (node.right != null) s.push(node.right);
//        }
//        Collections.reverse(res);
//        return res;
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            res.add(node.val);
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
        }
        return res;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            res.add(node.val);
            if (node.left != null) s.add(node.left);
            if (node.right != null) s.add(node.right);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        // 1.允许入栈和出栈  3指针指向右子树
        for (; node != null || !s.isEmpty(); node = node.right) {
            // 2.处理入栈和出栈
            for (; node != null; node = node.left) s.push(node);
            node = s.pop();
            res.add(node.val);
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            res.add(new ArrayList<>());
            while (size-- > 0) {
                TreeNode node = queue.poll();
                res.get(level - 1).add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return res;
    }
}
