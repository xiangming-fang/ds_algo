package indi.xm.jy.leetcode.Interview;

import indi.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/21 15:59
 * @description: 面试题 02.03. 删除中间节点
 */
public class Interview0203 {
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
