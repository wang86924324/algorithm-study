package homework.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 解题思路：
 * 1.DFS+组合去重（常规思路：记录搜索的其实位置）
 * 去重理解：假设数组中的元素a1 a2 a3..an 求总和为S的组合个数=包含a1+包含a2+。。。+包含an，所以搜索a[k]的时候，a1到a[k-1]元素都要剪掉。
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int start = 0;
        dfs(candidates, target, start, path, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) continue;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, res);
            path.remove(path.size() - 1);
        }
    }
}
