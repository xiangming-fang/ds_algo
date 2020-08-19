package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/8/17 14:58
 * @description: 328. 奇偶链表
 */
public class OddEvenList {
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
