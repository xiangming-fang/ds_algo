package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: albert.fang
 * @date: 2020/7/23 15:04
 * @description: 剑指 Offer 35. 复杂链表的复制
 * @description: 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class LeetCode_31 {

    private static Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node p = head;
        while (p != null){
            map.put(p,new Node(p.val));
            p = p.next;
        }
        Node q = head;
        while (q != null){
            map.get(q).next = map.get(q.next);
            map.get(q).random = map.get(q.random);
            q = q.next;
        }
        return map.get(head);
    }
}
