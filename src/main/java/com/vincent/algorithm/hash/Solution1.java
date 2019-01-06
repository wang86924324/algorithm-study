package com.vincent.algorithm.hash;

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 18;

        Solution1 solution1 = new Solution1();
        System.out.println(Arrays.toString(solution1.twoSum(nums, target)));

        System.out.println(Arrays.toString(solution1.twoSum2(nums, target)));

        System.out.println(Arrays.toString(solution1.twoSum2_repeate(nums, target)));

    }

    /**
     * 双重循环o(N平方)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return res;
    }


    // set o(N)
    // 思路：x+y=9 遍历x，只需要9-y是否在集合中即可。
    // 问题抽象为：遍历x，在左边的数跟x相加看是否满足等于9，左边的数可以放在set里面
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = hashMap.get(target - nums[i]);
            }
            hashMap.put(nums[i], i);
        }

        return res;
    }


    public int[] twoSum2_repeate(int[] nums, int target) {
        // check
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[2];
        // 遍历x，查找左边的值是否存在target-x，左边的值存在hashmap中
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }

            map.put(nums[i], i);
        }

        return res;

    }
}
