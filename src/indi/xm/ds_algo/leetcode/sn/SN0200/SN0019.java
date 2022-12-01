package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.ds_algo.leetcode.data_structure.ListNode;
import indi.xm.ds_algo.leetcode.util.ListNodeUtil;

/**
 * @author: albert.fang
 * @date: 2020/7/23 9:46
 * @description: 19. 删除链表的倒数第N个节点
 */
public class SN0019 {
    /**
     * 快慢指针
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(666);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        // pre指针先走n步
        for (int i = 0; i < n + 1 ; i++) {
            pre = pre.next;
        }
        // pre和cur指针同时走
        while (pre != null){
            pre = pre.next;
            cur = cur.next;
        }
        // 断链操作
        cur.next = cur.next.next;
        return dummy.next;
    }

    // 双指针 之 前后指针
    public ListNode removeNthFromEnd01(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }
        ListNode after = dummy;
        while (pre.next != null){
            pre = pre.next;
            after = after.next;
        }
        after.next = after.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode s = dummy ,f = dummy;

        // f先走n步
        for (int i = 0; i < n; i++) {
            f = f.next;
        }
        while (f != null){
            f = f.next;
            if ( f != null) s = s.next;
        }
        if (s.next != null){
            s.next = s.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        removeNthFromEnd1(ListNodeUtil.generateListNode(new Integer[]{1}),1);
        ListNode listNode = ListNodeUtil.generateListNode(new Integer[]{1,2,3,4,5});
        ListNode p = listNode;
        ListNode q = listNode;
        // 断链操作
        p.next = p.next.next;
        System.out.println();

    }
}
