package com.xm.jy.leetcode.doing;

import com.xm.jy.leetcode.data_structure.ListNode;

import java.util.LinkedList;

/**
 * @author: albert.fang
 * @date: 2020/8/19 18:43
 * @description: 重排列表
 */
public class ReorderList {

    // 双端队列
    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode p = head;
        while (p != null){
            queue.addLast(p);
            p = p.next;
        }
        while (!queue.isEmpty()){
            if (p == null){
                p = queue.pollFirst();
            }else {
                p.next = queue.pollFirst();
                p = p.next;
            }
            p.next = queue.pollLast();
            p = p.next;
        }
        if (p != null){
            p.next = null;
        }
    }
}
