package indi.xm.ds_algo.competition.weekcompetition.th321.sn3;

import indi.xm.ds_algo.leetcode.data_structure.ListNode;

import java.util.LinkedList;

/**
 * @Author: albert.fang
 * @Description: 从链表中移除节点
 * @Date: 2022/11/28 11:03
 */
public class Solution1 {

    // 单调队列
    public ListNode removeNodes(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null){
            while (!queue.isEmpty() && queue.peekLast().val < cur.val) queue.pollLast();
            queue.offer(cur);
            cur = cur.next;
        }
        ListNode dm = new ListNode();
        ListNode tmp = dm;
        while (!queue.isEmpty()){
            tmp.next = queue.poll();
            tmp = tmp.next;
        }
        return dm.next;
    }


}
