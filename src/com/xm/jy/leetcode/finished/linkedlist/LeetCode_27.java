package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;
import com.xm.jy.leetcode.util.ListNodeUtil;

/**
 * @author: albert.fang
 * @date: 2020/7/22 16:44
 * @description: 面试题 02.06. 回文链表
 * @description: 编写一个函数，检查输入的链表是否是回文的。eg：1->2->2->1
 *
 * @description: 234. 回文链表 12321   123321
 */
public class LeetCode_27 {
    private static boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode p = head;
        int count = 0;
        while (p != null){
            count ++;
            p = p.next;
        }
        // 上半段的最后一个节点位置
        int middle = count/2 ;
        // 反转后半段链表，位置： middle + 1 —— count
        ListNode q = head;
        for (int i = 1; i < middle; i++) {
            q = q.next;
        }
        ListNode pre = null;
        ListNode cur = q.next;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 用反转后的下半部分链表和之前未反转的链表进行逐个比较值，比较前middle位
        for (int j = 1; j <= middle; j++) {
            if (head.val != pre.val){
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] ants = {1,2};
        isPalindrome(ListNodeUtil.generateListNode(ants));
    }
}
