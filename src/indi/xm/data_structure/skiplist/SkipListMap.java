package indi.xm.data_structure.skiplist;

import indi.xm.data_structure.map.Map;

import java.util.Iterator;
import java.util.Random;

/**
 * @Author: xiangming.fang
 * @Date: 2023/3/28 18:00
 */
public class SkipListMap<K extends Comparable<K>,V> implements Map<K,V> {

    public static final int MAX_LEVEL  = 16;

    private int curMaxLevel = 1;

    private int size = 0;

    private Node head = new Node(MAX_LEVEL);

    private Random rd = new Random();

    @Override
    public void add(K key, V value) {

        int level = randomLevel();
        if (level > curMaxLevel) level = ++curMaxLevel;
        Node newNode = new Node(key, value,level);
        Node p = head;
        Node[] ss = new Node[level];
        // 从顶部往下找，更快
        for (int i = curMaxLevel - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].k.compareTo(key) < 0){
                p = p.next[i];
            }
            if (i < level){
                ss[i] = p;
            }
        }
        for (int i = level - 1; i >= 0; i--) {
            newNode.next[i] = ss[i].next[i];
            ss[i].next[i] = newNode;
        }
        size ++;
    }

    @Override
    public V remove(K key) {
        Node p = head;
        // slightly smaller
        Node[] ss = new Node[curMaxLevel];
        for (int i = curMaxLevel - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].k.compareTo(key) < 0){
                p = p.next[i];
            }
            ss[i] = p;
        }
        Node delNode = null;
        for (int i = curMaxLevel - 1; i >= 0; i--) {
            delNode = ss[i].next[i];
            if (delNode != null && delNode.k.compareTo(key) == 0) {
                ss[i].next[i] = delNode.next[i];
            }
        }
        size --;
        return delNode == null ? null : (V)delNode.v;
    }

    @Override
    public void set(K key, V value) {
        Node node;
        if (( node = getNode(key)) != null) {
            node.v = value;
        }
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : (V)node.v;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public int getSize() {
        return size;
    }


    public void clear(){
        head = new Node(MAX_LEVEL);
        size = 0;
        curMaxLevel = 1;
    }

    private Node getNode(K key){
        Node p = head;
        for (int i = curMaxLevel - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].k.compareTo(key) < 0){
                p = p.next[i];
            }
        }
        return p.next[0];
    }

    private int randomLevel(){
        int level = 1;
        while ((rd.nextInt() & 1) == 1 && level < MAX_LEVEL){
            level ++;
        }
        return level;
    }


    class Node<K extends Comparable<K>,V> {
        public K k;
        public V v;
        // p.next[i] 表示 p 节点的第 i 层 的下一个指向
        Node[] next;

        public Node(K k, V v,int level){
            this.k = k;
            this.v = v;
            this.next = new Node[level];
        }

        public Node(int level){
            this.next = new Node[level];
        }

        public Node(){

        }

        @Override
        public String toString() {
            return "Node{" +
                    "k=" + k +
                    ", v=" + v +
                    '}';
        }
    }

    public Iterator iterator(){
        return new Iterator() {

            Node p = head.next[0];

            int s = getSize();

            @Override
            public boolean hasNext() {
                return s != 0;
            }

            @Override
            public Object next() {
                s --;
                Node tmp = p;
                p = p.next[0];
                return tmp;
            }
        };
    }

    public Iterator iteratorForSet(){
        return new Iterator() {

            Node p = head.next[0];

            int s = getSize();

            @Override
            public boolean hasNext() {
                return s != 0;
            }

            @Override
            public Object next() {
                s --;
                Node tmp = p;
                p = p.next[0];
                return tmp.k;
            }
        };
    }
}
