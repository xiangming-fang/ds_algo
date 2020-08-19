package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/8/19 13:15
 * @description: 下一个更大的节点
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode p = head;
        int count = 0;
        while (p != null){
            count ++;
            p = p.next;
        }
        int[] result = new int[count];
        ListNode cur = head;
        for (int i = 0; i < result.length; i++) {
            ListNode next = cur.next;
            while (next != null){
                if (next.val > cur.val){
                    result[i] = next.val;
                    break;
                }
                next = next.next;
            }
            cur = cur.next;
        }
        return result;
    }
}
