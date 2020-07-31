package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;
import com.xm.jy.leetcode.util.LeetCodeUtil;
import com.xm.jy.leetcode.util.ListNodeUtil;

import java.util.Arrays;

/**
 * @author: albert.fang
 * @date: 2020/7/22 15:01
 * @description: 21. 合并两个有序链表
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode_24 {

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        ListNode first = l1;
        ListNode second = l2;
        int l1_length = 0;
        int l2_length = 0;
        while (l1 != null){
            l1_length ++;
            l1 = l1.next;
        }
        while (l2 != null){
            l2_length ++;
            l2 = l2.next;
        }
        Integer[] l1_array = new Integer[l1_length];
        Integer[] l2_array = new Integer[l2_length];
        for (int i = 0; i < l1_array.length; i++) {
            l1_array[i] = first.val;
            first = first.next;
        }
        for (int j = 0; j < l2_array.length; j++) {
            l2_array[j] = second.val;
            second = second.next;
        }
        Integer[] result = LeetCodeUtil.mergeTwoArrays(l1_array,l2_array);
        Arrays.sort(result);
        return ListNodeUtil.generateListNode(result);
    }


    public static void main(String[] args) {
        Integer[] ants = {1,2,4,5,3,4};
        Integer[] ants2 = {1,1,11,111};
        for (int ant : LeetCodeUtil.mergeTwoArrays(ants,ants2)) {
            System.out.println(ant);
        }
    }
}
