package indi.xm.data_structure;

/**
 * 自己定义链表 双向链表
 * TODO：有问题，删除头结点或者在头结点之前增加结点对this操作不了；暂时想不懂啊解决方法，后续修改
 */
public class MyLinkedList_1 {

    public int val;

    public MyLinkedList_1 next;

    public MyLinkedList_1 prev;

    // 链表长度
    public int length = getLength();

    /** Initialize your data structure here. */
    public MyLinkedList_1(int val) {
        this.val = val;
        this.prev = this;
        this.next = null;
    }
    public MyLinkedList_1() {
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (length == 0 || index >= length){
            return -1;
        }
        MyLinkedList_1 linkedList = this;
        while (index > 0){
            index --;
            linkedList = linkedList.next;
        }
        return linkedList.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyLinkedList_1 node = new MyLinkedList_1(val);
        // TODO 这种方式貌似不好直接对头结点进行操作
        this.prev = node;
        this.length ++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        MyLinkedList_1 tailNode = new MyLinkedList_1(val);
        MyLinkedList_1 linkedList = this;
        while( linkedList != null ){
            if (linkedList.next == null){
                linkedList.next = tailNode;
                this.length ++;
                break;
            }
            linkedList = linkedList.next;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // 等于链表的长度，则在末尾插入
        if (index == length ){
            addAtTail(val);
        }
        // 小于0，则插入在首位
        else if (index < 0){
            addAtHead(val);
        }
        // 有效的index，正常插入
        else if (index < length){
            MyLinkedList_1 newNode = new MyLinkedList_1(val);
            MyLinkedList_1 linkedList = this;
            for (int i = 1; i < index; i++) {
                linkedList = linkedList.next;
            }
            newNode.next = linkedList.next;
            linkedList.next = newNode;
            this.length ++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < length){
            MyLinkedList_1 linkedList = this;
            if (index > 0 && index < length -1){
                for (int i = 1; i < index; i++) {
                    linkedList = linkedList.next;
                }
                linkedList.next = linkedList.next.next;
            }else if (index == 0){
                // TODO 这种方式貌似不好直接对头结点进行操作
            }else if (index == length - 1){
                while (linkedList != null){
                    // 倒数第二个元素
                    if (linkedList.next.next == null){
                        linkedList.next = null;
                    }
                    linkedList = linkedList.next;
                }
            }
            this.length --;
        }
    }

    public int getLength(){
        MyLinkedList_1 linkedList = this;
        int length = 0;
        while (linkedList != null){
            length ++;
            linkedList = linkedList.next;
        }
        return length;
    }
}