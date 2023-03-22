package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/8/18 18:41
 * @description: 25.K 个一组翻转链表
 */
public class SN0025 {
    // 和两两交换区别不大，k=2的时候是两两交换
    // 因为两两交换多余剩下一个交换之后和没有交换是一样的
    // 但是当k不为2时，那么就要对剩下的链表长度于k进行判断，若大于k则翻转接下来的k个，若小于k，则保存原样的
    public ListNode reverseKGroup(ListNode head, int k) {
        // 若head节点数都不足k，那么直接返回head
        if (getLinkedListLength(head) < k){
            return head;
        }
        ListNode newNode = new ListNode(-1);
        // 这个指针不能动
        ListNode remain = newNode;
        ListNode move = newNode;
        ListNode cur = head;
        int count = 0;
        boolean flag = true;
        while (flag){
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = move.next;
                move.next = cur;
                cur = next;
                count ++;
            }
            if (count%k == 0){
                for (int j = 0; j < k; j++) {
                    move = move.next;
                }
            }
            if (getLinkedListLength(cur) < k){
                flag = false;
                move.next = cur;
            }
        }

        return remain.next;
    }

    public int getLinkedListLength(ListNode node){
        int count = 0;
        while (node != null){
            count ++;
            node = node.next;
        }
        return  count;
    }
}
