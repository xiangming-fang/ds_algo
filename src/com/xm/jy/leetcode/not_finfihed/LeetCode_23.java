package com.xm.jy.leetcode.not_finfihed;

import com.xm.jy.leetcode.data_structure.ListNode;
import com.xm.jy.leetcode.util.ListNodeUtil;

/**
 * @author: albert.fang
 * @date: 2020/7/22 14:39
 * @description: 面试题 02.07. 链表相交
 * @description: 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。
 * 换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 */
public class LeetCode_23 {
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null){
            while (headB != null){
                if (headA.next == headB){
                    return headB;
                }
                headB = headB.next;
            }
            headA = headA.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] one = {1,2,3,4,5};
        Integer[] two = {8,6,4,5};
        getIntersectionNode(ListNodeUtil.generateListNode(one),ListNodeUtil.generateListNode(two));
    }
}
