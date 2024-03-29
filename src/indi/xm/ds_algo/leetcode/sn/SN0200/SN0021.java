package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.data_structure.ListNode;
import indi.xm.ds_algo.leetcode.util.LeetCodeUtil;
import indi.xm.ds_algo.leetcode.util.ListNodeUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: albert.fang
 * @date: 2020/7/22 15:01
 * @description: 21. 合并两个有序链表
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class SN0021 {

    // 3、递归
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists3(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists3(l1,l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode newNode = new ListNode(-1);
        // 该指针不能移动
        ListNode remian = newNode;
        ListNode move = newNode;
        ListNode p = l1;
        ListNode q = l2;
        while (true){
            if (p.val <= q.val){
                move.next = p;
                p = p.next;
                move = move.next;
            }
            if (p == null){
                move.next = q;
                break;
            }
            if (q.val < p.val){
                move.next = q;
                q = q.next;
                move = move.next;
            }
            if (q == null){
                move.next = p;
                break;
            }
        }
        return remian.next;
    }

    private static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
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

    /******************* 2022-01-04 **************************/

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1,list2);
    }

    private ListNode merge(ListNode p, ListNode q) {
        if (p == null) return q;
        if (q == null) return p;

        if (p.val <= q.val){
            p.next = merge(p.next,q);
            return p;
        }

        q.next = merge(p,q.next);
        return q;
    }


    @Test
    public void test(){

    }
}
