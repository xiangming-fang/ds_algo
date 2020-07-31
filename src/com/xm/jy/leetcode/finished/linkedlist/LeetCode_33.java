package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;
import com.xm.jy.leetcode.util.ListNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: albert.fang
 * @date: 2020/7/24 11:32
 * @description: 23. 合并K个排序链表
 * @description: 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class LeetCode_33 {
    private static ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null){
                arrayList.add(list.val);
                list = list.next;
            }
        }
        if (arrayList.size() == 0){
            return null;
        }
        Integer[] integers = new Integer[arrayList.size()];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = arrayList.get(i);
        }
        Arrays.sort(integers);
        return ListNodeUtil.generateListNode(integers);
    }
}
