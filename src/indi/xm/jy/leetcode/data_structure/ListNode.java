package indi.xm.jy.leetcode.data_structure;

import java.util.List;

import java.util.ArrayList;

/**
 * definition singly-linked
 * 链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
    }
    public ListNode(){

    }

    public ListNode(int[] array){
        val = array[0];
        if (array.length > 1){
            recursionCreateListNode(this,array,1);
        }
    }

    /**
     * 递归创造链表
     * @param preNode 前面一个节点
     * @param array 数组
     * @param pos 位置
     */
    private void recursionCreateListNode(ListNode preNode,int[] array,int pos){
        if (array.length - 1 >= pos){
            ListNode cur = new ListNode();
            preNode.next = cur;
            cur.val = array[pos];
            recursionCreateListNode(cur,array,pos + 1);
        }
    }

    // 将 当前ListNode 对象转成 List
    public List<Integer> parseListNode(){
        ArrayList<Integer> res = new ArrayList<>();
        recursionTraverse(this,res);
        return res;
    }

    // 递归遍历链表
    private void recursionTraverse(ListNode node,List<Integer> list){
        if (node == null){
            return;
        }
        list.add(node.val);
        recursionTraverse(node.next,list);
    }
}