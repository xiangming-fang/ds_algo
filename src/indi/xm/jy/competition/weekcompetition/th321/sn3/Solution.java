package indi.xm.jy.competition.weekcompetition.th321.sn3;

import indi.xm.jy.leetcode.data_structure.ListNode;

import java.util.Stack;


/**
 * t3 从链表中移除节点
 */
public class Solution {


    // 思路：单调栈
    // 题意：要删除的链表节点是：临接的右边节点严格大于当前节点
    // 1、我们可以发现，最后所保留的答案是单调递减的,所以我们可以维护一个单调递减的栈
    // 2、最后用栈的元素再构成一个新的链表
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
