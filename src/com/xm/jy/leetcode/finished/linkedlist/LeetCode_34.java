package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;
import com.xm.jy.leetcode.util.ListNodeUtil;

import java.util.ArrayList;

/**
 * @author: albert.fang
 * @date: 2020/7/24 12:15
 * @description: 61. 旋转链表
 * @description: 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class LeetCode_34 {

    private static ListNode rotateRight1(ListNode head, int k) {
        ListNode p = head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (p != null){
            arrayList.add(p.val);
            p = p.next;
        }
        if (arrayList.size() == 0){
            return null;
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            int j = Math.abs(arrayList.size() + i - k%arrayList.size())%arrayList.size();
            arrayList1.add(arrayList.get(j));
        }
        Integer[] integers = new Integer[arrayList1.size()];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = arrayList1.get(i);
        }
        return ListNodeUtil.generateListNode(integers);
    }


    private static ListNode rotateRight2(ListNode head, int k){
        // 题目中的隐含条件，向右移动k个位置，那么移动之后，倒数第k个节点就变成了新链表的首节点
        // 然后我们这里只需要两个操作：1、断链第length - k和length - k + 1节点之间的链。2、将末尾节点的next指向原先的首节点
        ListNode p = head;
        ListNode q = head;
        int length = 0;
        while (p != null){
            length ++;
            p = p.next;
        }
        if (length == 0){
            return null;
        }
        k = k%length;
        if (k == 0 || k == length){
            return head;
        }
        // 找到第length - k个节点
        for (int i = 1; i < length - k; i++) {
            q = q.next;
        }
        // 用ratate引用指向length - k + 1节点
        ListNode rotateK = q.next;
        ListNode rotateK2 = q.next;
        // 1、断链
        q.next = null;

        // 找到最后一个节点
        for (int i = 1; i < k; i++) {
            rotateK2 = rotateK2.next;
        }
        // 2、链接之前的头结点
        rotateK2.next = head;
        return rotateK;
    }

    public static void main(String[] args) {
        rotateRight2(ListNodeUtil.generateListNode(new Integer[]{1}),1);
    }
}
