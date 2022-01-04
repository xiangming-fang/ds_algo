package indi.xm.jy.leetcode.sn.SN0200;

import indi.xm.jy.leetcode.data_structure.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0116
 * @Author: albert.fang
 * @Description: 填充每个节点的下一个右侧节点指针
 * @Date: 2021/9/2 18:21
 */
public class SN0116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect01(Node root) {
        if (root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<ArrayList<Node>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Node> nodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                nodes.add(node);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(nodes);
        }
        for (ArrayList<Node> singe : res) {
            for (int i = 0; i < singe.size() - 1; i++) {
                singe.get(i).next = singe.get(i + 1);
            }
        }
        return root;
    }

    /******************* 2022-01-04 **************************/

    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            Node pre = null;
            for (int i = 0; i < len; i++) {
                Node poll = queue.poll();
                if (pre != null) {
                    pre.next = poll;
                    pre = poll;
                }else {
                    pre = poll;
                }
                if (poll != null) {
                    if (poll.left != null) queue.offer(poll.left);
                    if (poll.right != null) queue.offer(poll.right);
                }
            }
        }
        return root;
    }


}
