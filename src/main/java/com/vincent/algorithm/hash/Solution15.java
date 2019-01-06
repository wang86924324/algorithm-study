package com.vincent.algorithm.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 高频题目
 */
public class Solution15 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15, 11, 7};
        int target = 20;

        Solution15 solution15 = new Solution15();
        System.out.println(Arrays.toString(solution15.threeSum(nums, target)));
        System.out.println(Arrays.toString(solution15.threeSum2(nums, target)));
    }


    public int[] threeSum(int[] nums, int target) {
        int[] result = new int[3];
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        result[0] = i;
                        result[1] = j;
                        result[2] = k;
                    }
                }
        return result;
    }

    public int[] threeSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap;

        int aimNum = 0;
        int[] result = new int[3];
        for (int i = 0; i < nums.length; i++) {
            // i作为固定值来看待，所以不需要在hashmap中
            hashMap = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                aimNum = target - nums[i] - nums[j];
                if (hashMap.containsKey(aimNum)) {
                    result[0] = i;
                    result[1] = hashMap.get(target - nums[i] - nums[j]);
                    result[2] = j;
                    break;
                }
                hashMap.put(nums[j], j);
            }
        }

        return result;
    }
}
