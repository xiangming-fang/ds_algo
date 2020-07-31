package com.xm.jy.leetcode.util;

import com.xm.jy.leetcode.data_structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2020/7/22 14:47
 * @description: 单链表的工具类
 */
public class ListNodeUtil {
    /**
     * 新建一个单链表
     * @param ants 单链表节点的值
     * @return
     */
    public static ListNode generateListNode(Integer[] ants){
        List<ListNode> listNodes = new ArrayList<>();
        for (int ant : ants) {
            ListNode listNode = new ListNode(ant);
            listNodes.add(listNode);
        }
        for (int i = 0; i < listNodes.size(); i++) {
            if (i < listNodes.size() - 1){
                listNodes.get(i).next = listNodes.get(i + 1);
            }
        }
        return listNodes.get(0);
    }
}
