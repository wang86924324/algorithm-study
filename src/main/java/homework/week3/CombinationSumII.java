package homework.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] hasVisited = new boolean[candidates.length];
        int start = 0;
        dfs(candidates, target, start, hasVisited, path, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, boolean[] hasVisited, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 去重：每个数字执行出现一次
            // 排序后相同元素，第二次直接剪枝去重，第二次遍历的时候hasVisited[i-1]=false
            if (i > 0 && candidates[i] == candidates[i - 1] && !hasVisited[i - 1]) continue;

            // 剪枝：递归终止
            if (target < candidates[i]) continue;

            path.add(candidates[i]);
            hasVisited[i] = true;
            dfs(candidates, target - candidates[i], i + 1, hasVisited, path, res);
            hasVisited[i] = false;
            path.remove(path.size() - 1);
        }
    }

}
