package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.data_structure.ListNode;
import indi.xm.ds_algo.leetcode.util.ListNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: albert.fang
 * @date: 2020/7/24 11:32
 * @description: 23. 合并K个排序链表
 * @description: 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class SN0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (ListNode list : lists) {
            result = mergeTwoLists(result,list);
        }
        return result;
    }

    // 递归两两合并
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    private static ListNode mergeKLists1(ListNode[] lists) {
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
