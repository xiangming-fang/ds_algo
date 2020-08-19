package com.xm.jy.leetcode.doing;

import com.xm.jy.leetcode.data_structure.ListNode;

import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/19 16:06
 * @description: 正序两数相加；两数相加 II
 */
public class AddTwoNumbersByOrder {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode p = l1;
        ListNode q = l2;
        while (p != null){
            stack1.push(p.val);
            p = p.next;
        }
        while (q != null){
            stack2.push(q.val);
            q = q.next;
        }
        // TODO
        return null;
    }
}
