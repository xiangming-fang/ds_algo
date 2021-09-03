package indi.xm.jy.leetcode.sn.SN2000;

import indi.xm.jy.leetcode.data_structure.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1669
 * @Author: albert.fang
 * @Description: 合并两个链表
 * @Date: 2021/9/3 16:26
 */
public class SN1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dh1 = list1;
        for (int i = 0; i < b + 1; i++) {
            dh1 = dh1.next;
        }
        ListNode dh2 = list1;
        for (int i = 0; i < a - 1; i++) {
            dh2 = dh2.next;
        }
        dh2.next = list2;

        while (dh2.next != null){
            dh2 = dh2.next;
        }
        dh2.next = dh1;
        return list1;
    }
}
