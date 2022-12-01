package indi.xm.ds_algo.leetcode.sn.SN1000;

import indi.xm.ds_algo.leetcode.data_structure.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0817
 * @Author: albert.fang
 * @Description: 817. 链表组件
 * @Date: 2022/10/12 9:49
 */
public class SN0817 {

    public int numComponents(ListNode head, int[] nums) {
        boolean[] hashtable = new boolean[10000];
        for (int num : nums) {
            hashtable[num] = true;
        }
        int count = 0;
        ListNode p = head;
        while (p != null){
            if (hashtable[p.val] && (p.next == null || !hashtable[p.next.val])) {
                count ++;
            }
            p = p.next;
        }
        return count;
    }

}
