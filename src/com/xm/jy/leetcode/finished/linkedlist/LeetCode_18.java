package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/22 10:35
 * @description: 面试题 02.02. 返回倒数第 k 个节点的值
 */
public class LeetCode_18 {
    private static int kthToLast1(ListNode head, int k) {
        // 先反转
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 再正序取得第k个值
        ListNode node_k = pre;
        for (int i = 1; i < k; i++) {
            node_k = node_k.next;
        }
        return node_k.val;
    }

    private static int kthToLast2(ListNode head, int k) {
        ListNode saveNode = head;
        int nodeLength = 0;
        // 得到链表的长度
        while(head != null){
            nodeLength++;
            head = head.next;
        }
        // 倒序取第k个，相当于正序 nodeLength - k + 1
        int i = 1;
        int result = 0;
        while ( i <= nodeLength - k + 1){
            if (i == nodeLength - k + 1){
                result = saveNode.val;
            }
            saveNode = saveNode.next;
            i++;
        }
        return result;
    }
}
