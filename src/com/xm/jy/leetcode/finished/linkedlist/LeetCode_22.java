package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;
import com.xm.jy.leetcode.util.ListNodeUtil;

/**
 * @author: albert.fang
 * @date: 2020/7/22 14:12
 * @description: 876. 链表的中间结点
 * @description: 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 */
public class LeetCode_22 {
    private static ListNode middleNode(ListNode head) {
        int nodeLength = 0;
        ListNode saveOne = head;
        while (head != null){
            nodeLength ++;
            head = head.next;
        }
        int middle = nodeLength/2 +1;
        for (int i = 1; i < middle; i++) {
            saveOne = saveOne.next;
        }
        return saveOne;
    }

    public static void main(String[] args) {
        Integer[] ants = {1,2,3,4,5};
        middleNode(ListNodeUtil.generateListNode(ants));
    }
}
