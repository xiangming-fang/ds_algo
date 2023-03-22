package indi.xm.ds_algo.leetcode.Interview;

import indi.xm.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/8/17 15:20
 * @description: 面试题 02.08  环路检测
 */
public class Interview0208 {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            // 说明压根不是带环的单链表
            if (fast == null ||fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            // 快慢指针在环中相遇
            if (fast == slow){
                break;
            }
        }
        // 让fast指针重新指向头结点（也可以新创建一个指针指向头结点，为了节省内存，复用fast指针）。
        fast = head;
        // 让fast指针和slow指针一样，都移动一个单位
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
