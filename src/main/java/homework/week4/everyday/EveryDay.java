package homework.week4.everyday;

import homework.week4.ListNode;
import homework.week4.TreeNode;

public class EveryDay {
    // 分治
    public TreeNode sortedListToBST(ListNode head) {
        ListNode left = head;
        ListNode right = null;
        return buildTree(left, right);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            // 数学归纳法 1 2 3 null的话，第一层选择2 第二层左节点(1,2)，右边节点(2,3,null)需要把1和3給查询出来
            // 先看第二层的左节点（1,2）需要返回节点1，（1,2）的mid是1，作为2的左节点。
            // mid为1的左右区间为，（1,1）(2,2)应该返回null。
            return null;
        }

        ListNode middle = getMiddle(left, right);
        TreeNode cur = new TreeNode();
        cur.val = middle.val;
        cur.left = buildTree(left, middle);
        cur.right = buildTree(middle.next, right);

        return cur;
    }

    private ListNode getMiddle(ListNode left, ListNode right) {
        ListNode slow = left, fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode first =new ListNode(1);
        first.next=new ListNode(2);
        first.next.next=new ListNode(3);
        new EveryDay().sortedListToBST(first);
    }
}
