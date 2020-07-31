package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;
import com.xm.jy.leetcode.util.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2020/7/23 9:46
 * @description: 19. 删除链表的倒数第N个节点
 */
public class LeetCode_29 {
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

    /**
     * 用arrayList接住链表的每个值，然后将倒数第n个值删掉，再用arraylist里的值，重新创建一个新的链表
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd2(ListNode head, int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode q = head;
        int length = 0;
        while (q != null){
            arrayList.add(q.val);
            length ++;
            q = q.next;
        }

        arrayList.remove(arrayList.size() - n);

        // 说明之前传进来的链表长度为1，直接移除没有数据了
        if (arrayList.size() == 0){
            return null;
        }

        // 重新生成一个新的链表返回
        Integer[] integers = new Integer[arrayList.size()];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = arrayList.get(i);
        }
        return ListNodeUtil.generateListNode(integers);
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
