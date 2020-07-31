package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;
import com.xm.jy.leetcode.util.ListNodeUtil;

import java.util.ArrayList;

/**
 * @author: albert.fang
 * @date: 2020/7/22 17:25
 * @description: 203. 移除链表元素
 * @description: 删除链表中等于给定值 val 的所有节点。
 */
public class LeetCode_28 {
    private static ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode p = head;
        while ( p != null){
            arrayList.add(p.val);
            p = p.next;
        }
        for (int i = arrayList.size() -1; i >= 0; i--) {
            if (arrayList.get(i) == val){
                arrayList.remove(i);
            }
        }
        // 如果节点值和val全部相等，直接返回null
        if (arrayList.size() == 0){
            return null;
        }
        Integer[] ants = new Integer[arrayList.size()];
        for (int j = 0; j < arrayList.size(); j++) {
            ants[j] = arrayList.get(j);
        }
        ListNode listNode = ListNodeUtil.generateListNode(ants);
        return listNode;
    }

    private static ListNode removeElements2(ListNode head, int val){
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(val + 1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        cur = cur.next;
        while (cur != null){
            // 如果当前节点的值等于val值的，那么改变前面一个指针的next指向，并且让cur指针到下一个节点上
            if (cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }
            // 如果不相等，那么同时移动两个指针
            else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Integer[] ants = {1,1};
        removeElements(ListNodeUtil.generateListNode(ants),1);
    }
}
