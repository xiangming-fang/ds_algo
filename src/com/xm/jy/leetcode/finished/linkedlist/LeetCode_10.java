package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/21 13:21
 * @description: 206. 反转链表
 */
public class LeetCode_10 {
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while ( cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}