package com.vincent.algorithm.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if ("([{".contains(String.valueOf(c))) {
                stack.push(c);
            } else if (stack.isEmpty() || !"(){}[]".contains(stack.pop() + String.valueOf(c))) {
                return false;
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid2("()"));
    }

    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        for (char c : s.toCharArray()) {
            if ("([{".contains(String.valueOf(c))) {
                stack.push(c);
            } else if (stack.isEmpty() || !"(){}[]".contains(stack.pop() + String.valueOf(c))) {
                continue;
            } else {
                i = i + 2;
            }

        }

        return i;
    }
}
