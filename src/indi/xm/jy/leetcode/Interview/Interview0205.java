package indi.xm.jy.leetcode.Interview;

import indi.xm.jy.leetcode.data_structure.ListNode;
import indi.xm.jy.leetcode.util.ListNodeUtil;

import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/19 14:53
 * @description: 面试题 02.05 : 链表求和：用链表表示数位，第一个为个位，依次类推
 * @description: 两数相加
 */
public class Interview0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode virtual = new ListNode(-1);
        ListNode move = virtual;
        // 下位应该进多少位
        int carry = 0;
        boolean flag = true;
        while (flag){
            // 这个节点的具体数值
            int num = 0;
            if (p == null && q == null){
                num = carry%10;
                if (num > 0){
                    flag = false;
                }else {
                    break;
                }
            }
            if (q == null && p != null){
                num = (p.val + carry)%10;
                carry = (p.val + carry)/10;
                p = p.next;
            }
            if (p == null && q != null){
                num = (q.val + carry)%10;
                carry = (q.val + carry)/10;
                q = q.next;
            }
            if (q != null && p != null){
                num = (p.val + q.val + carry)%10;
                carry = (p.val + q.val + carry)/10;
                p = p.next;
                q = q.next;
            }
            move.next = new ListNode(num);
            move = move.next;
        }
        return virtual.next;
    }

    public int getLength(ListNode node){
        int count = 0;
        while (node != null){
            count ++;
            node = node.next;
        }
        return count;
    }



    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
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
        String value1 = "";
        String value2 = "";
        int len1 = stack1.size();
        for (int i = 0; i < len1; i++) {
            value1 += stack1.pop();
        }
        int len2 = stack2.size();
        for (int i = 0; i < len2; i++) {
            value2 += stack2.pop();
        }
        // TODO 这种方式有问题，当value1或value2的数值大于Integer.MaxValue时，则会报NumberFormatException
        char[] sum = String.valueOf(Integer.valueOf(value1) + Integer.valueOf(value2)).toCharArray();
        ListNode virtual = new ListNode(-1);
        ListNode temp = virtual;
        for (int i = sum.length - 1; i >= 0; i--) {
            temp.next = new ListNode(Integer.valueOf(String.valueOf(sum[i])));
            temp = temp.next;
        }
        return virtual.next;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[]{9};
        Integer[] l2 = new Integer[]{1,9,9,9,9,9,9,9,9,9};
        ListNode node1 = ListNodeUtil.generateListNode(l1);
        ListNode node2 = ListNodeUtil.generateListNode(l2);
        addTwoNumbers1(node1,node2);
    }
}
