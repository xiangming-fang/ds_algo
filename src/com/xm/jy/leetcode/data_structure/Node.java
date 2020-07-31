package com.xm.jy.leetcode.data_structure;

/**
 * @author: albert.fang
 * @date: 2020/7/23 15:17
 * @description: Definition for a Node.
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
