package com.xm.jy.leetcode.finished.tree;

import com.xm.jy.leetcode.data_structure.ListNode;
import com.xm.jy.leetcode.data_structure.TreeNode;

import java.util.ArrayList;

/**
 * @author: albert.fang
 * @date: 2020/7/27 10:39
 * @description: 109. 有序链表转换二叉搜索树
 * @description: 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class LeetCode_46 {
    // BST是二叉搜索树
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null){
            arrayList.add(head.val);
            head = head.next;
        }
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        return highBalance(array,0,array.length - 1);
    }

    // 分析思路，二叉搜索树的中序遍历就是按从小到大的顺序排列的
    // 又因为是高度平衡，每个节点的左右子树深度差不能超过1，所以将中点作为根节点，然后不断遍历左右子树（每个父亲节点都为相应区间的中心节点）
    public TreeNode highBalance(int[] ints,int startIndex,int endIndex){
        if (startIndex > endIndex){
            return null;
        }
        int mid = (startIndex + endIndex)/2;
        TreeNode treeNode = new TreeNode(ints[mid]);
        treeNode.left = highBalance(ints,startIndex,mid - 1);
        treeNode.right = highBalance(ints,mid + 1,endIndex);
        return treeNode;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        return getBalanceByLinkedList(head,null);
    }

    public TreeNode getBalanceByLinkedList(ListNode head,ListNode tail){
        if (head == null || head == tail){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        TreeNode root  = new TreeNode(mid.val);
        root.left = getBalanceByLinkedList(head,slow);
        root.right = getBalanceByLinkedList(slow.next,tail);
        return root;
    }
}
