package com.vincent.algorithm.str;

import com.vincent.algorithm.tree.TreeNode;

public class Demo0723 {
    public static String reverse(String str) {
        // 翻转
        // 进入stack
        // 输入："a-bC-dEf-ghIj"
        //输出："j-Ih-gfE-dCba"
        // 双指针
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (!Character.isAlphabetic(arr[left]) && left < right) left++;
            while (!Character.isAlphabetic(arr[right]) && left < right) right--;
            swap(arr, left, right);
            left++;
            right--;
        }

        return new String(arr);
    }

    private static void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    public boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) return true;
        String str2 = str.toLowerCase();
        int left = 0;
        int right = str2.length() - 1;
        while (left < right) {
            if (left < right && !Character.isLetterOrDigit(str2.charAt(left))) left++;
            if (left < right && !Character.isAlphabetic(str2.charAt(right))) right--;
            if (left < right && str2.charAt(left) != str2.charAt(right)) return false;
            left++;
            right--;
        }

        return true;

        //  栈：出栈的时候，一个一个对比
    }

//    public int minDepth(TreeNode root) {
//        // 层次遍历
//        // 遇到第一个叶子节点，那么结束遍历，返回深度。
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int path = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            path++;
//            while (size-- > 0) {
//                TreeNode current = queue.poll();
//                if (current.left == null && current.right == null) return path;
//                if (current.left != null) queue.add(current.left);
//                if (current.right != null) queue.add(current.right);
//            }
//        }
//
//        return 0;
//    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int minValue = Integer.MAX_VALUE;
        if (root.left != null) {
            minValue = Math.min(minValue, minDepth(root.left));
        }
        if (root.right != null) {
            minValue = Math.min(minValue, minDepth(root.right));
        }


        return minValue + 1;
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int slow = -1;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) swap(nums, ++slow, fast);
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Demo0723().moveZeroes(nums);
        ;
        System.out.println(nums.toString());
    }

    


}
