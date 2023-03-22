package indi.xm.ds_algo.leetcode.sn.SN2000;

import indi.xm.data_structure.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1721
 * @Author: albert.fang
 * @Description: 交换链表中的节点
 * @Date: 2021/9/3 15:29
 */
public class SN1721 {


    // 两个点的位置：
    // 1、k
    // 2、k + (len - 1) -(k-1) * 2
    public ListNode swapNodes(ListNode head, int k) {
        int len = 0;
        ListNode dh = head;
        while (dh != null){
            dh = dh.next;
            len ++;
        }
        ListNode firstK = head;
        for (int i = 1; i < k; i++) {
            firstK = firstK.next;
        }
        int k1 = k + (len - 1) - (k - 1) * 2;
        ListNode secondK = head;
        for (int i = 1; i < k1; i++) {
            secondK = secondK.next;
        }
        int temp = secondK.val;
        secondK.val = firstK.val;
        firstK.val = temp;
        return head;
    }
}
