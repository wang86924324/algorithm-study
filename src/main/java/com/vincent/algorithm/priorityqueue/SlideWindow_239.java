package com.vincent.algorithm.priorityqueue;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * 解题思路
 * 1.Map Heap：遍历数组的时候，把倒数第二个元素移除Heap中，然后把当前元素添加Heap中，堆顶元素就是我们需要的。
 * 2.Dequeue：双端队列。假设窗口每次向有滑动一个元素，那么最大元素左边的元素永远没机会成为最大元素，这些元素就可以删除。最大元素就在队列的左端，插入元素在队列的右端。
 * 算法细节：
 * 1.使用LinkList来存储滑动窗口的位置。因为窗口移动过程中需要通过位置来判断最左边的元素是否需要移除。
 * 2.怎么保证左边第一个永远是最大的呢？这里包含一个地推逻辑：
 * 2.1 假设左边第一个是最大的，删除越界元素后，只需要做如下操作：从队列尾部开始想头部扫描，这些位置的元素只要小于或者等于待添加进来的元素，那么这些元素就可以删除。
 * 为什么要从队列尾部开始扫描？地推思路：（1）我们可以假设窗口中有一个位置元素是最大元素，并且窗口已形成。
 * 当移动窗口时，只要从窗口尾部开始扫描然后删除不大于当前节点数就能能保证窗口当前元素是最小的元素。也就能保证最左边的永远是窗口中最大的数。
 */
public class SlideWindow_239 {


    static void printIntArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("array is empty");
            return;
        }

        for (int i : array) {
            System.out.println(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        // 假设nums.length>=K
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                priorityQueue.add(nums[i]);
            } else {
                priorityQueue.remove(nums[i - k]);
                priorityQueue.add(nums[i]);
            }
            if (i >= k - 1) {
                result[i - k + 1] = priorityQueue.peek();
            }
        }

        return result;

    }

    public int[] maxSlidingWindow_repeat5(int[] nums, int k) {
        // check
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[Math.max(nums.length - k + 1, 1)];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                maxHeap.add(nums[i]);
            } else {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }

            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek();
            }
            if (nums.length == 1) {
                result[0] = maxHeap.peek();
            }
        }

        return result;
    }

    public int[] maxSlidingWindow_repeat(int[] nums, int k) {
        // check
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[Math.max(nums.length - k + 1, 1)];

        // 创建Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                maxHeap.add(nums[i]);
            } else {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }

            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek();
            }
        }
        if (result.length == 1) {
            result[0] = maxHeap.peek();
        }

        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums == null) return new int[0];

        Deque<Integer> window = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 窗口移动后，删除越界元素的位置
            if (i >= k && !window.isEmpty() && window.peek() <= i - k) {
                window.poll();
            }
            // 维护窗口：当前窗口中小于或者等于新加入的元素的位置都移除掉。
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }

            window.offer(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[window.peek()];
            }
        }

        return result;
    }

    public int[] maxSlidingWindow3(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }

        return r;
    }

    public int[] maxSlidingWindow3_Repeat(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        if (k < 0) {
            //throw 参数非法异常
            return new int[0];
        }

        int[] result = new int[Math.max(1, nums.length - k + 1)];
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 剔除越界元素
            if (!window.isEmpty() && window.peek() < i - k) {
                window.poll();
            }
            // 维护窗口：遍历窗口的口中的元素，
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }

            // 添加当前位置
            window.add(i);

            // 维护结果
            if (i >= k - 1) {
                result[i - k + 1] = nums[window.peek()];
            }
        }

        if (nums.length < k) {
            result[0] = nums[window.peek()];
        }
        return result;
    }


    public Integer[] maxSlidingWindow4_Repeat(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new Integer[0];
        }

        // 存储索引
        Deque<Integer> window = new LinkedList<>();

        // 存储值
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 窗口越界，移除左边节点
            if (i >= k) {
                window.removeFirst();
            }

            // 比当前节点小的节点需要移除窗口
            while (nums[window.peekFirst()] < nums[i])
                window.removeFirst();

            ((LinkedList<Integer>) window).add(i);
            if (i >= k) {
                result.add(window.peekFirst());
            }
        }


        Integer[] a = result.toArray(new Integer[0]);
        return a;
    }


    public int[] maxSlidingWindow5_Repeat(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }

        LinkedList<Integer> window = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!window.isEmpty() && window.peek() < i - k + 1) {
                window.poll();
            }
            while (!window.isEmpty() && nums[window.peekFirst()] < nums[i]) {
                window.pollLast();
            }
            window.add(i);
            if (i >= k - 1) {
                result[resultIndex++] = nums[window.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlideWindow_239 slideWindow_239 = new SlideWindow_239();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};

        printIntArray(slideWindow_239.maxSlidingWindow5_Repeat(nums, 3));

    }
}
