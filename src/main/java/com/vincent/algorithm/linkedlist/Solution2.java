package com.vincent.algorithm.linkedlist;

public class Solution2 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val);
            }
            return sb.toString();
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        // 进位
        int plus = 0;
        while (l1 != null) {
            // 初始化对象
            pre.next = new ListNode(0);
            if (l2 != null) {
                pre.next.val = (l1.val + l2.val + plus) % 10;
                plus = (l1.val + l2.val + plus) / 10;
                l2 = l2.next;
            } else {
                pre.next.val = (l1.val + plus) % 10;
                plus = (l1.val + plus) / 10;
            }
            l1 = l1.next;

            // 向后移动
            pre = pre.next;
        }

        while (l2 != null) {
            pre.next = new ListNode(0);
            pre.next.val = (l2.val + plus) % 10;
            plus = (l2.val + plus) / 10;
            pre = pre.next;
            l2 = l2.next;
        }

        if (plus > 0) {
            pre.next = new ListNode(1);
        }


        return dummy.next;
    }


}
