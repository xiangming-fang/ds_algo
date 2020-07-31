package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/22 10:35
 * @description: 剑指 Offer 22. 链表中倒数第k个节点
 */
public class LeetCode_19 {
    private static ListNode getKthFromEnd(ListNode head, int k) {
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
}
