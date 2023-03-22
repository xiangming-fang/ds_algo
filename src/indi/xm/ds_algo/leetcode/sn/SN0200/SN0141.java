package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/21 17:33
 * @description: 141. 环形链表
 */
public class SN0141 {
    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            // 防止fast.next.next报空指针，如果fast的next指向的节点为null，那么肯定是没有环的
            if (fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
