package indi.xm.jy.leetcode.sn.SN0400;

import indi.xm.jy.leetcode.data_structure.ListNode;

/**
 * @author: albert.fang
 * @date: 2020/8/19 13:30
 * @description: 254.分隔链表
 */
public class SN0254 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k < 1 || k > 50){
            throw new RuntimeException("输入的k值有误");
        }
        ListNode[] result = new ListNode[k];
        if (root == null){
            for (int i = 0; i < k; i++) {
                result[i] = null;
            }
            return result;
        }
        int count = 0;
        ListNode p = root;
        while (p != null){
            count ++;
            p = p.next;
        }
        ListNode helper = root;
        // 如果链表长度小于等于k
        if (count <= k){
            for (int i = 0; i < result.length; i++) {
                if (helper != null){
                    ListNode next = helper.next;
                    helper.next = null;
                    result[i] = helper;
                    helper = next;
                }
            }
        }else {
            // 平均每份几个
            int eachCount = count/k;
            // 平均之后，多出的个数
            int moreCount = count%k;
            int[] helperArray = new int[k];
            for (int i = 0; i < helperArray.length; i++) {
                helperArray[i] = eachCount;
            }
            // 如果平均之后有多出来的个数,往helperArray数组的前面几个加1；
            if (moreCount > 0){
                for (int i = 0; i < moreCount; i++) {
                    helperArray[i] += 1;
                }
            }
            ListNode remain = root;
            for (int j = 0; j < helperArray.length; j++) {
                for (int m = 0; m < helperArray[j] - 1; m++) {
                    helper = helper.next;
                }
                ListNode temp = helper.next;
                helper.next = null;
                result[j] = remain;
                remain = temp;
                helper = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(6%4);
    }
}
