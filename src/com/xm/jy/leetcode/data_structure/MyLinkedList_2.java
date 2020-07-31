package com.xm.jy.leetcode.data_structure;

/**
 * @author: albert.fang
 * @date: 2020/7/23 18:11
 * @description: 707. 设计链表
 */
public class MyLinkedList_2<E> {

    private Node<Integer> node;

    private int length = getLength();

    /** Initialize your data structure here. */
    public MyLinkedList_2() {

    }

    public MyLinkedList_2(Node<Integer> head) {
        this.node = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (length == 0 || index >= length){
            return -1;
        }
        Node<Integer> node = this.node;
        while (index > 0){
            index --;
            node = node.next;
        }
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node<Integer> headNode = new Node<>(val,null);
        headNode.next = this.node;
        this.node = headNode;
        this.length ++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node<Integer> tailNode = new Node<>(val,null);
        Node<Integer> node = this.node;
        if (node == null){
            this.node = tailNode;
        }else {
            while( node != null ){
                if (node.next == null){
                    node.next = tailNode;
                    this.length ++;
                    break;
                }
                node = node.next;
            }
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // 等于链表的长度，则在末尾插入
        if (index == length ){
            addAtTail(val);
        }
        // 小于0，则插入在首位
        else if (index <= 0){
            addAtHead(val);
        }
        // 有效的index，正常插入
        else if (index < length){
            Node<Integer> newNode = new Node<>(val,null);
            Node<Integer> node = this.node;
            for (int i = 1; i < index; i++) {
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
            this.length ++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < length){
            Node<Integer> node = this.node;
            if (index > 0 && index < length -1){
                for (int i = 1; i < index; i++) {
                    node = node.next;
                }
                node.next = node.next.next;
            }else if (index == 0){
                node = node.next;
                this.node = node;
            }else if (index == length - 1){
                while (node != null){
                    // 倒数第二个元素
                    if (node.next.next == null){
                        node.next = null;
                    }
                    node = node.next;
                }
            }
            this.length --;
        }
    }

    public int getLength(){
        Node node = this.node;
        int length = 0;
        while (node != null){
            length ++;
            node = node.next;
        }
        return length;
    }

    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }
}
