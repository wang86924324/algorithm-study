package array;

import com.vincent.algorithm.tree.TreeNode;

import java.util.*;

public class everyday {

    //    public int[] intersect(int[] nums1, int[] nums2) {
    //        if (nums1.length > nums2.length) {
    //            return intersect(nums2, nums1);
    //        }
    //        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    //        for (int num : nums1) {
    //            int count = map.getOrDefault(num, 0) + 1;
    //            map.put(num, count);
    //        }
    //        int[] intersection = new int[nums1.length];
    //        int index = 0;
    //        for (int num : nums2) {
    //            int count = map.getOrDefault(num, 0);
    //            if (count > 0) {
    //                intersection[index++] = num;
    //                count--;
    //                if (count > 0) {
    //                    map.put(num, count);
    //                } else {
    //                    map.remove(num);
    //                }
    //            }
    //        }
    //        return Arrays.copyOfRange(intersection, 0, index);
    //    }

    // 解题思路：
    // Map统计较长数组的各个元素的评率
    // 遍历端数组，如果统计个数小于Map的长度，那么就加到公共元素里面
    public int[] intersect(int[] nums1, int[] nums2) {
        // 小技巧：确定第一个参数为长度小的参数
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums2)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int[] intersection = new int[nums1.length];
        int index = 0;

        for (Integer num : nums1) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                if (--count > 0)
                    map.put(num, count);
                else
                    map.remove(num);
            }
        }

        return Arrays.copyOfRange(intersection, 0, index);
    }

    // 思路：遍历数组，维护大顶堆，返回大顶推的堆顶元素
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k)
            return new int[0];

        Queue<Integer> queue = new PriorityQueue<>(k);
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i >= k - 1) {
                result[i - k + 1] = queue.poll();
            }
        }
        return result;

    }

    // dfs/bfs+剪树枝
    // https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
    // 变形 统计数量  优劣
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuild = new StringBuilder();
        dfs(3, 3, stringBuild, result);
        return result;
    }

    private void dfs(int leftCount, int rightCount, StringBuilder stringBuilder, List<String> result) {
        //  teminate
        if (leftCount == 0 && rightCount == 0) {
            result.add(stringBuilder.toString());
        }

        if (leftCount > 0) {
            stringBuilder.append('(');
            dfs(leftCount - 1, rightCount, stringBuilder, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (rightCount > 0) {
            stringBuilder.append(')');
            dfs(leftCount, rightCount - 1, stringBuilder, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                List<Integer> cur = queue.poll();
                if (cur.size() == nums.length) permutes.add(cur);
                for (int num : nums) {
                    if (cur.contains(num)) continue;
                    List<Integer> next = new ArrayList<>(cur);
                    next.add(num);
                    queue.add(next);
                }
            }
        }

        return permutes;
    }


    // 遍历树 每个节点都相等
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}
