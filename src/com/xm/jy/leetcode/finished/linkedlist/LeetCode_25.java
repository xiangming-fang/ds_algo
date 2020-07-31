package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;
import com.xm.jy.leetcode.util.ListNodeUtil;

import java.util.ArrayList;

/**
 * @author: albert.fang
 * @date: 2020/7/22 15:39
 * @description: 剑指 Offer 18. 删除链表的节点
 * @description: 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 */
public class LeetCode_25 {
    private static ListNode deleteNode1(ListNode head, int val) {
        ListNode p = head;
        ListNode preDelete = head;
        // 用于表示要删除的节点下标
        int nodeIndex = 0;
        while ( p != null){
            nodeIndex ++;
            if (p.val == val){
                break;
            }
            p = p.next;
        }
        // 找到nodeIndex位置上要删除的节点的前一个节点
        for (int i = 1; i < nodeIndex - 1; i++) {
            preDelete = preDelete.next;
        }
        // 要删除的节点
        ListNode delete = preDelete.next;
        // 找到nodeIndex后面的那个节点
        ListNode nextDelete = preDelete.next.next;

        // TODO 得到位置1——preDelete的链表

        delete.val = nextDelete.val;
        delete.next = nextDelete.next;
        return delete;
    }

    private static ListNode deleteNode2(ListNode head, int val) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode p = head;
        // 找到要被删除的节点下标，从0开始算
        int count = 0;
        int positionIndex = 0;
        while ( p != null){
            if (val == p.val){
                positionIndex = count;
            }
            count ++;
            arrayList.add(p.val);
            p = p.next;
        }
        arrayList.remove(positionIndex);
        Integer[] ants = new Integer[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ants[i] = arrayList.get(i);
        }
        return ListNodeUtil.generateListNode(ants);
    }

    public static void main(String[] args) {
        Integer[] ints = {4,5,1,9};
        deleteNode2(ListNodeUtil.generateListNode(ints),5);
    }
}
