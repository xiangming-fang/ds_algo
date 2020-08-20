package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;
import com.xm.jy.leetcode.util.ListNodeUtil;

import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/19 16:06
 * @description: 正序两数相加；两数相加 II
 */
public class AddTwoNumbersByOrder {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();
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
        int carry = 0;
        int temp = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0){
            if (stack1.isEmpty() && stack2.isEmpty()){
                temp = 0;
            }
            if (stack1.isEmpty() && !stack2.isEmpty()){
                temp = stack2.pop();
            }
            if (stack2.isEmpty() && !stack1.isEmpty()){
                temp = stack1.pop();
            }
            if (!stack1.isEmpty() && !stack2.isEmpty()){
                temp = stack1.pop() + stack2.pop();
            }
            resultStack.push((temp + carry)%10);
            carry = (temp + carry)/10;
        }
        ListNode result = new ListNode(-1);
        ListNode move = result;
        while (!resultStack.isEmpty()){
            move.next = new ListNode(resultStack.pop());
            move = move.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[]{7,2,4,3};
        Integer[] l2 = new Integer[]{5,6,4};
        ListNode node1 = ListNodeUtil.generateListNode(l1);
        ListNode node2 = ListNodeUtil.generateListNode(l2);
        addTwoNumbers(node1,node2);
    }
}
