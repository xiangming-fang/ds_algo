package indi.xm.jy.leetcode.sn.SN0400;

import indi.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/21 13:21
 * @description: 206. 反转链表
 */
public class SN0206 {

    // 时隔一年，回来看，清晰易懂 2021-09-02。
    // 第一次搞这个，搞半天，这就是成长 和 进步。
    // 对链表的操作更加清楚了。
    private ListNode reverseList01(ListNode head) {
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

    // 递归 —— 直接递归到链表的末尾开始操作
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}