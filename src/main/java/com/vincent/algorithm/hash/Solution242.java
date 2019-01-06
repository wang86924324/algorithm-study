package com.vincent.algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;

public class Solution242 {
    public static void main(String[] args) {
        Solution242 sol = new Solution242();
        System.out.println(sol.isAnagram("anagram", "nagaram"));
        System.out.println(sol.isAnagram("rat", "car"));

        System.out.println(sol.isAnagram2("anagram", "nagaram"));
        System.out.println(sol.isAnagram2("rat", "car"));
    }

    // 排序
    public boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);


        char[] tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);

        return Arrays.toString(sCharArray).equals(Arrays.toString(tCharArray));
    }


    public boolean isAnagram2(String s, String t) {
        HashMap<Integer, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sMap.put((int) c, sMap.get(c) == null ? 1 : sMap.get(c) + 1);
        }

        HashMap<Integer, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put((int) c, tMap.get(c) == null ? 1 : sMap.get(c) + 1);
        }

        return sMap.equals(tMap);
    }


}
