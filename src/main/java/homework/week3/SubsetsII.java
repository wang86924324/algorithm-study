package homework.week3;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * https://leetcode-cn.com/problems/subsets-ii/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 重复元素一般先排序，然后是map来去重
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        int start = 0;
        for (int count = 0; count <= nums.length; count++) {
            dfs(nums, count, start, hasVisited, path, res);
        }

        return res;
    }

    private void dfs(int[] nums, int count, int start, boolean[] hasVisited, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == count) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 相同元素，第二次无效
            if (i > 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) continue;
            hasVisited[i] = true;
            path.add(nums[i]);
            dfs(nums, count, i + 1, hasVisited, path, res);
            path.remove(path.size() - 1);
            hasVisited[i] = false;
        }
    }


}
