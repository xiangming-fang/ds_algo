package indi.xm.ds_algo.competition.weekcompetition.th270;

import indi.xm.ds_algo.leetcode.data_structure.ListNode;

public class SN0002 {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null){
            cur = cur.next;
            len++;
        }
        if (len == 1){
            return null;
        }
        int mid = len/2;
        ListNode preNode = head;
        for (int i = 0; i < mid - 1; i++) {
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
        return head;
    }

}
