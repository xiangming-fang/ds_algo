package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/22 10:54
 * @description: 剑指 Offer 06. 从尾到头打印链表
 * @description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class LeetCode_20 {
    private static int[] reversePrint1(ListNode head) {
        int listNodeLength = 0;
        ListNode head2 = head;
        while (head != null){
            head = head.next;
            listNodeLength ++;
        }
        int[] ants = new int[listNodeLength];
        for (int i = 0; i < listNodeLength; i++) {
            ants[i] = head2.val;
            head2 = head2.next;
        }
        int[] reverseInts = new int[listNodeLength];
        for (int j = 0; j < ants.length; j++) {
            reverseInts[ants.length - 1 - j] = ants[j];
        }
        return reverseInts;
    }

    private static int[] reversePrint2(ListNode head) {
        // 先反转
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 得到链表长度，用于创建固定数组长度
        int listNodeLength = 0;
        // 保存一份反转之后的结果
        ListNode result = pre;
        while (pre != null){
            pre = pre.next;
            listNodeLength ++;
        }
        int[] ants = new int[listNodeLength];
        for (int i = 0; i < ants.length; i++) {
            ants[i] = result.val;
            result = result.next;
        }
        return ants;
    }



    public static void main(String[] args) {
        ListNode listNode  = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        for (int i : reversePrint1(listNode)) {
            System.out.println(i);
        }
    }
}
