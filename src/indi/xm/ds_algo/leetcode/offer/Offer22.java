package indi.xm.ds_algo.leetcode.offer;

import indi.xm.ds_algo.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/22 10:35
 * @description: 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Offer22 {
    private static ListNode getKthFromEnd01(ListNode head, int k) {
        // 先反转
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 再正序反转从第一个到第k个节点
        ListNode pre2 = null;
        ListNode cur2 = pre;
        int count = 0;
        while (count <= k){
            ListNode next = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = next;
        }
        return pre2;
    }


    // 双指针 之 先后指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }
        while (pre != null){
            pre = pre.next;
            cur = cur.next;
        }
        return cur;
    }
}
