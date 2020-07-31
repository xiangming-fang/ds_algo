package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;

import java.util.*;

/**
 * @author: albert.fang
 * @date: 2020/7/22 11:44
 * @description: 面试题 02.01. 移除重复节点
 * @description: 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class LeetCode_21 {
    private static ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null){
            return head;
        }
        LinkedHashMap<Integer,Boolean> hashMap = new LinkedHashMap<>();
        while (head != null){
            hashMap.put(head.val,true);
            head = head.next;
        }
        List<ListNode> nodes = new ArrayList<>();
        for (Integer integer : hashMap.keySet()) {
            ListNode node = new ListNode(integer);
            nodes.add(node);
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (i < nodes.size() -1){
                nodes.get(i).next = nodes.get(i + 1);
            }
        }
        return nodes.get(0);
    }

    private static ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null){
            return head;
        }
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        while (head != null){
            hashSet.add(head.val);
            head = head.next;
        }
        List<ListNode> listNodes = new ArrayList<>();
        for (Integer integer : hashSet) {
            ListNode node = new ListNode(integer);
            listNodes.add(node);
        }
        for (int i = 0; i < listNodes.size(); i++) {
            if (i < listNodes.size() -1){
                listNodes.get(i).next = listNodes.get(i + 1);
            }
        }
        return listNodes.get(0);
    }
}
