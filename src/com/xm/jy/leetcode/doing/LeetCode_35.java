package com.xm.jy.leetcode.doing;

import com.xm.jy.leetcode.data_structure.ListNode;

import java.util.HashSet;

/**
 * @author: albert.fang
 * @date: 2020/7/24 14:34
 * @description: 817. 链表组件
 */
public class LeetCode_35 {
    static int count = 0;
    private static int numComponents(ListNode head, int[] G) {
        if (G.length == 0){
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : G) {
            hashSet.add(i);
        }
        ListNode p = head;
        while ( p != null){
            if (hashSet.contains(p.val)){
                p = p.next;
                if (p == null || !hashSet.contains(p.val)){
                    count ++;
                }
            }else {
                p = p.next;
            }
        }
        // TODO
        return count;
    }
}
