package homework.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/increasing-subsequences/
 */
public class IncreasingSubsequences {
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        int start = 0;
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        dfs(nums, start,last, path, result);
//        return result;
//    }
//
//    private void dfs(int[] nums, int start,int last, List<Integer> path, List<List<Integer>> result) {
//        // teminate
//        if (path.size() > 1) {
//            // 这里不用return，因为要取所有可能
//            result.add(new ArrayList<>(path));
//        }
//
//        // current logic
//        for (int i = start; i < nums.length; i++) {
//            // 去重
//            if (i > 0 && nums[i - 1] == nums[i]) continue;
//
//            path.add(nums[start]);
//            dfs(nums, start + 1, path, result);
//            path.remove(path.size() - 1);
//        }
//    }

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            // 选择当前元素
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        // 上一个元素跟当前元素相等，当前层不选的树枝剪掉。
        if (nums[cur] != last) {
            // 不选择当前元素
            dfs(cur + 1, last, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        new IncreasingSubsequences().findSubsequences(nums);
    }

    // 双指针
    public int maxArea(int[] height) {
        if(height.length==0) return 0;
        int maxArea=0;
        int left=0,right=height.length-1;
        while(left<right) {
            // 当前层
            maxArea = Math.max(maxArea,Math.abs(height[right]-height[left])*(right-left));
            // 下一层
            if(height[left]<height[right]) left++;
            else right--;
        }

        return maxArea;
    }
}
