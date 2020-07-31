package com.xm.jy.leetcode.not_finfihed;

import com.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/21 17:42
 * @description: 142. 环形链表 II（判断是否有环，并且返回入环的第一个节点）
 */
public class LeetCode_16 {
    private static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            if (fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){

            }
        }
        return null;
    }
}
