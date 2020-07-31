package com.xm.jy.leetcode.finished.linkedlist;

import com.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/7/21 15:07
 * @description: 1290. 二进制链表转整数
 */
public class LeetCode_12 {
    static String value = "";
    private static int getDecimalValue(ListNode head) {
        value += head.val;
        if (head.next != null){
            getDecimalValue(head.next);
        }
        return addByPrecent(value);
    }

    public static void main(String[] args) {
        System.out.println(addByPrecent("101"));
    }

    /**
     * 二进制转十进制的权相加法
     * @param str 入参
     * @return
     */
    private static int addByPrecent(String str){
        int sum = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars.length - 1 - i;
            String s = String.valueOf(chars[i]);
            sum += Integer.parseInt(s) * Math.pow(2,index);
        }
        return sum;
    }
}
