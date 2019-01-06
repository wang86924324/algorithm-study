package com.vincent.algorithm.recursions;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 算法思路：
 * 1.暴力求解  两重循环：第二重循环记录count(x)，并且算出最大的数 时间负责读N平方
 * 2.HashMap 一重循环计数  o(N)的时间复杂度 空间复杂度o（1）
 * 3.排序，然后遍历统计  时间负责读NlogN
 * 4.递归分治
 */
public class Solution169 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        int[] nums2 = new int[]{2, 2, 1, 1, 1, 2, 2};
        Solution169 solution169 = new Solution169();
        System.out.println(solution169.majorityElement(nums));
        System.out.println(solution169.majorityElement(nums2));

        System.out.println(solution169.majorityElement2(nums));
        System.out.println(solution169.majorityElement2(nums2));
    }

    // 暴力求解
    public int majorityElement(int[] nums) {
        int maxCount = 0;
        int maxValue = -1;
        int tempCount;
        for (int i = 0; i < nums.length; i++) {
            tempCount = 1;
            for (int j = i + 1; j < nums.length; j++) {
                // count nums[i]
                if (nums[i] == nums[j]) {
                    tempCount++;
                }
            }
            if (tempCount > maxCount) {
                maxCount = tempCount;
                maxValue = nums[i];
            }
        }

        return maxValue;
    }

    // hashMap计数
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.get(num) == null ? 1 : hashMap.get(num) + 1);
            if (hashMap.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    // 排序 中间位置的数一定是majority
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 计数排除法：遍历所有的数，遇到非大多数就减一，最后剩下的数就是majority
    public int majorityElement4(int[] nums) {
        int count = 1;
        int majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
                // 当前数不是majority
                if (count == 0) {
                    count = 1;
                    majority = nums[i];
                }
            }
        }
        return majority;
    }
}
