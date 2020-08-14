package com.vincent.algorithm.linkedlist;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    public void printLink() {
        ListNode node = this;
        System.out.println("start----");
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println("end -------");
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode three = new ListNode(4);
        head.next = first;
        first.next = second;
        second.next = three;

        //reverseList(head).printLink();
        //reverse4(head).printLink();
        //reverseTwoPairs(head).printLink();
        //reverse6(head).printLink();
        //reverse7(head).printLink();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static ListNode reverse2(ListNode head) {
        ListNode temp = new ListNode();
        //链表反转
        while (head.next != null) {
            ListNode next = head.next;
            //head往后移动
            head.next = next.next;
            next.next = temp.next;
            temp.next = next;
        }

        return temp;
    }

    public static ListNode reverse3(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static ListNode reverse4(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode next = null;
        ListNode next2 = null;
        while (head != null && head.next != null) {
            next = head.next;
            next2 = head.next.next;

            next.next = head; // 2->1
            head.next = next2; // 1->3
            temp.next = next;  // temp=1
            temp = head;


            head = next2; // head=3
        }

        return temp;
    }


    public static ListNode reverseTwoPairs(ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = cur;
        ListNode next = null;
        while (cur != null && cur.next != null) {
            next = cur.next;
            pre.next = cur.next;
            cur.next = next.next;
            next.next = cur;

            // 向后移动
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

    public static ListNode reverse5(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;

            head.next = pre;

            pre = head;
            head = next;
        }

        return pre;
    }


    public static ListNode reverse6(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            // 缓存
            ListNode next = head.next;
            // 核心
            head.next = pre;
            // 移动指针
            pre = head;
            head = next;
        }

        return pre;
    }

    public static ListNode reverse7(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        ListNode next;
        while (head != null && head.next != null) {
            next = head.next;

            // 核心
            pre.next = head.next;
            head.next = next.next;
            next.next = head;

            // 移动
            pre = head;
            head = head.next;
        }

        return dummy.next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        ListNode next = null;
        while (notNull(head, k)) {
            // swap k
            swap(head, pre, k);

            pre = head;
            head = head.next;
        }
        return dummy.next;
    }

    private static void swap(ListNode head, ListNode pre, int k) {
        ListNode[] arrayList = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            arrayList[i] = cur;
            cur = cur.next;
        }

        // p->第k个元素互换
        pre.next = arrayList[k - 1];

        // head->第k+1个元素
        if (k > 1) {
            head.next = arrayList[k - 1].next;
        }

        // 第k-1个元素到第二个元素
        if (k > 2) {
            arrayList[k-2].next = arrayList[k-3];
        }
    }

    private static boolean notNull(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

}