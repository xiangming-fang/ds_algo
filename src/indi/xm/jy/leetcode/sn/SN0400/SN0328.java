package indi.xm.jy.leetcode.sn.SN0400;

import indi.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/8/17 14:58
 * @description: 328. 奇偶链表
 */
public class SN0328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode odd = head;
        ListNode even1 = head.next;
        ListNode even2 = head.next;
        while (even2 != null){
            if (even2.next == null){
                break;
            }
            odd.next = even2.next;
            odd = odd.next;
            even2.next = odd.next;
            even2 = even2.next;
        }
        odd.next = even1;
        return head;
    }
}
