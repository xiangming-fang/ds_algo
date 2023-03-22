package indi.xm.ds_algo.leetcode.sn.SN1000;

import indi.xm.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/22 14:12
 * @description: 876. 链表的中间结点
 * @description: 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 */
public class SN0876 {
    private static ListNode middleNode01(ListNode head) {
        int nodeLength = 0;
        ListNode saveOne = head;
        while (head != null){
            nodeLength ++;
            head = head.next;
        }
        int middle = nodeLength/2 +1;
        for (int i = 1; i < middle; i++) {
            saveOne = saveOne.next;
        }
        return saveOne;
    }

    // 双指针 之 快慢指针
    public ListNode middleNode02(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null){
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode s = head;
        ListNode f = head;
        while (f != null){
            f = f.next;
            if (f != null) f = f.next;
            else return s;
            s = s.next;
        }
        return s;
    }

    public static void main(String[] args) {
        Integer[] ants = {1,2,3,4,5};
    }
}
