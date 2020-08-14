package com.vincent.algorithm.others;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] array = s.toCharArray();
        Set<Integer> set;
        for (int i = 0; i < array.length; i++) {
            set = new HashSet<>();
            int current = 0;
            int j = i;
            while (j < array.length && !set.contains(Integer.valueOf(array[j]))) {
                set.add(Integer.valueOf(array[j]));
                current++;
                j++;
            }

            if (current > max) max = current;
        }

        return max;
    }

    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(test());
    }


    public static boolean test() {
        int i = 10;
        try {
            throw new Exception("something error");
        } catch (Exception e) {
            System.out.println("Exception from e");
            return false;
        } finally {
            switch (i) {
                case 10:
                    System.out.println("finally:" + i);
                    break;
                default:
                    break;
            }
        }
    }

}
