package indi.xm.jy.competition.weekcompetition.th321.sn3;

import indi.xm.jy.leetcode.data_structure.ListNode;

import java.util.Stack;


/**
 * t3
 */
public class Solution {


    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        ListNode cur = head;
        while (cur != null){
            while (!stk.isEmpty() && cur.val > stk.peek().val) stk.pop();
            stk.push(cur);
            cur = cur.next;
        }
        ListNode dm = new ListNode();
        ListNode tmp = dm;
        for (ListNode listNode : stk) {
            tmp.next = listNode;
            tmp = tmp.next;
        }
        return dm.next;
    }


}
