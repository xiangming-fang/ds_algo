package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.ds_algo.leetcode.data_structure.ListNode;
import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0086
 * @Author: albert.fang
 * @Description: 分隔链表
 * @Date: 2021/10/8 17:03
 */
public class SN0086 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = head;
        // 比 x 大的链表
        ListNode gtx = new ListNode();
        ListNode gtx2 = gtx;
        // 比 x 小的链表
        ListNode ltx = new ListNode();
        ListNode ltx2 = ltx;
        while (dummy != null){
            if (dummy.val < x){
                ltx2.next = new ListNode(dummy.val);
                ltx2 = ltx2.next;
            }
            else {
                gtx2.next = new ListNode(dummy.val);
                gtx2 = gtx2.next;
            }
            dummy = dummy.next;
        }
        ltx2.next = gtx.next;
        return ltx.next;
    }

    @Test
    public void test(){
        ListNode listNode = new ListNode(new int[]{1,4,3,2,5,2});
        ListNode resNode = partition(listNode, 3);
        System.out.println(resNode.parseListNode());
    }
}
