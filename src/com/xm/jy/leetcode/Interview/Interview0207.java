package com.xm.jy.leetcode.Interview;

import com.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/8/18 10:14
 * @description: 面试题 02.07 链表相交
 */
public class Interview0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        // 用于判断是否相交
        boolean flag = false;
        // a指针走完headA，改为false;
        boolean aEnd = true;
        // b指针走完headB，改为false;
        boolean bEnd = true;
        // 让a指针走完headA，再指向headB的头结点
        // 让b指针走完headB，再指向headA的头结点
        while (true){
            if (a == b){
                flag = true;
                break;
            }
            a = a.next;
            b = b.next;
            if (a == null && aEnd){
                aEnd = false;
                a = headB;
            }
            if (b == null && bEnd){
                bEnd = false;
                b = headA;
            }
            // a从headB开始走，走到最后一个节点，还没找到相遇的那么退出循环
            if (a == null && !aEnd){
                break;
            }
            // b从headA开始走，走到最后一个节点，还没找到相遇的那么退出循环
            if (b == null && !bEnd){
                break;
            }
        }
        if (flag){
            return a;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        // 暴力解决，双重循环
        while (a != null){
            // 因为a移动一个节点，b就要从头开始和a这个指针比较内存地址，所以a后移，b要重新指向头部headB的头部位置
            ListNode b = headB;
            while (b != null){
                if (a == b){
                    return a;
                }
                b = b.next;
            }
            a = a.next;
        }
        return null;
    }
}
