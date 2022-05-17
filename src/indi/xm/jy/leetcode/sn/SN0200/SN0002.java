package indi.xm.jy.leetcode.sn.SN0200;

import indi.xm.jy.leetcode.data_structure.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0002
 * @Author: albert.fang
 * @Description: 两数相加
 * @Date: 2022/5/17 15:43
 */
public class SN0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode ret = dummy;
        ListNode p = l1,q = l2;
        // 是否需要进位
        boolean flag = false;
        while (p != null || q != null){
            int s;
            if (flag){
                s = (p == null ? 0 : p.val) + (q == null ? 0 : q.val) + 1;
                flag = false;
            }else {
                s = (p == null ? 0 : p.val) + (q == null ? 0 : q.val);
            }
            if (p != null){
                p = p.next;
            }
            if (q != null){
                q = q.next;
            }

            if (s >= 10) {
                flag = true;
            }
            ret.next = new ListNode(s % 10);
            ret = ret.next;
        }
        if (flag){
            ret.next = new ListNode(1);
        }
        return dummy.next;
    }

}
