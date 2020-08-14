package com.vincent.algorithm.others;

import com.google.common.collect.Lists;

import java.awt.image.ImageProducer;
import java.util.*;

public class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }

        return null;
    }

    // 排序 三指针（去重）
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left - 1] == nums[left]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 15};
        int[] result = twoSum(array, 9);
        System.out.println(result == null ? "" : result[0] + " " + result[1]);
    }
}
