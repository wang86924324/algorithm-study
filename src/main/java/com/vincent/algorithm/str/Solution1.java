package com.vincent.algorithm.str;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.io.*;
import java.util.*;


public class Solution1 {

    /**
     * // 默认情况，copy一次，粘贴n-1次
     * // 从2开始，如果能被i整除，就等于n/i+copy 1次 粘贴i-1
     *
     * @param n
     * @return
     */
    public int minSteps(int n) {
        if (n == 1) return 0;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) return n / i + i;
        }
        return n;
    }

    static class Node {
        public Node() {
        }

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer key;
        public Integer value;
    }


    public static void main(String[] args) {
        Node node = new Node(1, 111);
        Node node2 = new Node(2, 222);
        List<Node> nodes = new ArrayList<>();
        nodes.add(node);
        nodes.add(node2);

        List<Node> list = Lists.newArrayList();
        list.forEach(node1 -> System.out.println(node.value));

    }

}

