package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/21 14:05
 * @description: 92. 反转链表 II（部分反转）
 */
public class LeetCode_11 {
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n){
            return head;
        }
        ListNode ant = head;
        ListNode lastPart = head;
        // 找到反转前的那个节点
        for (int i = 1; i < m - 1; i++) {
            ant = ant.next;
        }
        // 找到n之后的那个几点
        for (int k = 1; k < n+1;k++){
            lastPart = lastPart.next;
        }
        // 反转部分链表
        ListNode pre = lastPart;
        ListNode cur = null;
        if (m == 1) {
            cur = head;
        } else {
            cur = ant.next;
        }
        for (int j = 1; j <= n-m+1; j++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 改变反转前的那个节点的next指向
        if (m != 1){
            ant.next = pre;
        }else {
            head = pre;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
