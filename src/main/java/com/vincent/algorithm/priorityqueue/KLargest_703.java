package com.vincent.algorithm.priorityqueue;

import java.util.PriorityQueue;

public class KLargest_703 {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        kthLargest.add(3);   // returns 4
        kthLargest.add(5);   // returns 5
        kthLargest.add(10);  // returns 5
        kthLargest.add(9);   // returns 8
        kthLargest.add(4);   // returns 8
    }

    /**
     * 问题：https://leetcode.com/problems/kth-largest-element-in-a-stream/
     * 解题思路
     * 1.用数组存储K各元素，每次对K个元素排序，最快的时间复杂度是o(KlogK),总共有N个元素，那么总的时间复杂度是NKlogK
     * 2.我们只需要最大或者最小元素，数组加排序有点大材小用，我们可以用Min Heap来存储这个元素，我们记得Fibbonacci堆的存储和find-min的效率是o（1）,n个元素，那么时间负责度即是o(N)
     */
    static class KthLargest {

        PriorityQueue<Integer> priorityQueue;
        int k;

        public KthLargest(int k, int[] nums) {
            priorityQueue = new PriorityQueue<Integer>(k);
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            if(priorityQueue.size()< k){
                priorityQueue.add(val);
            }
            else if (priorityQueue.peek() < val) {
                priorityQueue.remove();
                priorityQueue.add(val);
            }
            return priorityQueue.peek();
        }
    }
}
