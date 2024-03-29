package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.data_structure.ListNode;
import indi.xm.ds_algo.leetcode.util.ListNodeUtil;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * @author: albert.fang
 * @date: 2020/7/22 16:32
 * @description: 83. 删除排序链表中的重复元素
 * @description: 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class SN0083 {

    private static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        LinkedHashSet hashSet = new LinkedHashSet();
        ListNode p = head;
        while (p != null){
            hashSet.add(p.val);
            p = p.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Object o : hashSet) {
            arrayList.add((Integer)o);
        }
        Integer[] ants = new Integer[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ants[i] = arrayList.get(i);
        }
        return ListNodeUtil.generateListNode(ants);
    }
}
