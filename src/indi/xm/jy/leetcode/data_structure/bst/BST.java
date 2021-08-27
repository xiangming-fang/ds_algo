package indi.xm.jy.leetcode.data_structure.bst;

import indi.xm.jy.leetcode.data_structure.array.Array;
import org.junit.Test;

import java.util.Random;

/**
 * bst
 *
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    private Node root;

    private int size;

    private int leftSize;

    private int rightSize;

    class Node {
        E e;
        Node left;
        Node right;

        Node(E e){
            this.e = e;
        }
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) <= 0) {
            if (node == root) {
                leftSize++;
            }
            node.left = add(node.left, e);
        } else {
            if (node == root) {
                rightSize++;
            }
            node.right = add(node.right, e);
        }
        return node;
    }

    public void inorder(Array<E> array) {
        inorder(root, array);
    }

    private void inorder(Node node, Array<E> array) {
        if (node == null) {
            return;
        }
        inorder(node.left, array);
        array.addLast(node.e);
        inorder(node.right, array);
    }

    public int getSize() {
        return size;
    }

    public int getLeftSize() {
        return leftSize;
    }

    public int getRightSize() {
        return rightSize;
    }

    @Test
    public void test() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            bst.add(random.nextInt(1000000));
        }
        Array<Integer> array = new Array<>();
        bst.inorder(array);
        for (int i = 1; i < array.getSize(); i++) {
            if (array.get(i).compareTo(array.get(i - 1)) < 0) {
                System.out.println("bst 创建失败");
            }
        }
        System.out.println(bst.getLeftSize());
        System.out.println(bst.getRightSize());
        System.out.println(bst.getSize());
    }
}