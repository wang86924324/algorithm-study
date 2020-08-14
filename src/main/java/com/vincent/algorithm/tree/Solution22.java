package com.vincent.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public static void main(String[] args) {
        Solution22 sol = new Solution22();
        sol.printList(sol.generateParenthesis(2));
    }


    private static void printList(List<String> res) {
        for (String s : res) {
            System.out.println(s);
        }
    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", 0, 0, n);
        return result;
    }

    public void generateParenthesis(List<String> result, String str, int left, int right, int n) {
        // terminator
        if (left == right && left == n) {
            result.add(str);
            return;
        }

        // condition drill
        if (left < n) {
            generateParenthesis(result, str + "(", left + 1, right, n);
        }

        if (right < n && right < left) {
            generateParenthesis(result, str + ")", left, right + 1, n);
        }
    }
}
