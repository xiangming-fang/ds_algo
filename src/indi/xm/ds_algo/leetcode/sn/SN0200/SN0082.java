package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.ds_algo.leetcode.data_structure.ListNode;

import java.util.TreeSet;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0082
 * @Author: albert.fang
 * @Description: 删除排序链表中的重复元素 II
 * @Date: 2021/9/3 13:47
 */
public class SN0082 {
    public ListNode deleteDuplicates(ListNode head) {
        TreeSet<Integer> set = new TreeSet<>();
        ListNode dh = new ListNode(-200);
        dh.next = head;
        ListNode cur = dh;
        // 找到所有重复的节点值
        while (cur != null){
            ListNode next = cur.next;
            if (next != null){
                if (cur.val == next.val) {
                    set.add(cur.val);
                }
            }
            cur = cur.next;
        }
        ListNode second = dh;
        while (second.next != null){
            if (set.contains(second.next.val)){
                second.next = second.next.next;
                continue;
            }
            second = second.next;
        }
        return dh.next;
    }
}
