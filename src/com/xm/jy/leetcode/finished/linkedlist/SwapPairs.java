package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/8/18 13:12
 * @description: 两两交换链表中的节点
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode newNode = new ListNode(-1);
        // 这个指针不能动
        ListNode remain = newNode;
        ListNode move = newNode;
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = move.next;
            move.next = cur;
            cur = next;
            count ++;
            if (count%2 == 0){
                move = move.next.next;
            }
        }
        return remain.next;
    }
}
