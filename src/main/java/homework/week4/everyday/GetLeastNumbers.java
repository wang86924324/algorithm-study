package homework.week4.everyday;

import javafx.util.Pair;

import java.util.*;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {
    // 1.排序 NlogN
    // 2. NlogK
    // 3.快速选择
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (arr.length <= k) {
//            return arr;
//        }
//
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        for (int num : arr) heap.add(num);
//
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) res[i] = heap.poll();
//        return res;
//    }

    /**
     * 我们的目的是寻找最小的 kk 个数。假设经过一次 partition 操作，枢纽元素位于下标 mm，也就是说，左侧的数组有 mm 个元素，是原数组中最小的 mm 个数。那么：
     * <p>
     * 若 k = m，我们就找到了最小的 kk 个数，就是左侧的数组；
     * 若 k<m ，则最小的 k 个数一定都在左侧数组中，我们只需要对左侧数组递归地 parition 即可；
     * 若 k>m，则左侧数组中的 m 个数都属于最小的 k 个数，我们还需要在右侧数组中寻找最小的 k−m 个数，对右侧数组递归地 partition 即可。
     **/
    class Solution {
        // 最好的情况，假设有序，就是二分查找
        // 平均情况：主定理 O(N)
        // 最坏的情况
        public int[] getLeastNumbers(int[] arr, int k) {
            //这里直接传k-1了
            quickselect(arr, 0, arr.length - 1, k - 1);
            return Arrays.copyOfRange(arr, 0, k);
        }

        private void quickselect(int[] arr, int start, int end, int k) {
            if (start == end) return;
            int target = arr[start];
            int i = start, j = end;
            // partition [0,j]有序
            while (i <= j) {
                while (i <= j && arr[i] < target) i++;
                while (i <= j && arr[j] > target) j--;
                swap(arr, i, j);
            }

            if (k <= j) quickselect(arr, start, j, k);
            if (k >= i) quickselect(arr, i, end, k - i);
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

//        private void quickselect(int[] nums, int start, int end, int k) {
//            if (start == end) return;
//            int pivot = nums[start];
//            int i = start, j = end;
//            // 双指针partition，可以理解为找到二分查找的mid，其中j=mid-1,i=mid+1
//            while (i <= j) {
//                while (i <= j && nums[i] < pivot) i++;
//                while (i <= j && nums[j] > pivot) j--;
//                if (i <= j) swap(nums, i++, j--);
//            }
//            // 二分递归,终止条件是mid等于k
//            if (k <= j) quickselect(nums, start, j, k);
//            if (k >= i) quickselect(nums, i, end, k);
//        }
//
//        private void swap(int[] nums, int i, int j) {
//            int temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//        }

    }


    // 1.暴力法 O(N^4)
    // 2.map  O(N^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        res.add(getArray(nums, i, j, left, right));
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                        left++;
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return res;
    }

    private List<Integer> getArray(int[] nums, int left1, int left2, int right1, int right2) {
        List<Integer> array = new ArrayList<>();
        array.add(nums[left1]);
        array.add(nums[left2]);
        array.add(nums[right1]);
        array.add(nums[right2]);
        return array;
    }

    // 1.BFS
    // 2.
//    public int jump(int[] nums) {
//        if (nums.length == 0) return 0;
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(0);
//        int level = 0;
//        while (!queue.isEmpty()) {
//            level++;
//            int size = queue.size();
//            while (size-- > 0) {
//                int cur = queue.poll();
//                if (cur == nums.length) return level--;
//                int num = nums[cur];
//                for (int i = 1; i <= num; i++) {
//                    queue.add(cur + i);
//                }
//            }
//        }
//
//        return -1;
//    }

    // DP
    // DFS剪枝
    // 贪心：三指针
    // 可以理解为滑动窗口相遇，这里一次小窗口就是一次跳跃，两个窗口相连，说明跳跃相接，类似于接力棒交接。
    // 首先有个窗口[0,end],其中end=nums[0]+0
    // i个窗口为[i,maxPosition],其中maxPostion=max(i+nums[i])，其中i=0,1,...end。
    // 当到i跟end相遇，那么窗口就变成[0,maxPosition]
    // 同时step+1，遍历完所有的节点，返回step即可
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        int[] array = {2, 3, 0, 1, 4};
        int target = 0;
        //new GetLeastNumbers().fourSum(array, 0);
        System.out.println(new GetLeastNumbers().jump(array));
    }
}
