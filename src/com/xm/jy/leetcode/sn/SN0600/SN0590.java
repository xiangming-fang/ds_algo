package com.xm.jy.leetcode.sn.SN0600;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2021/4/20 18:58
 * @description: 590：N叉树的后序遍历
 */
public class SN0590 {
    // definition for a node
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root,result);
        return result;
    }

    private void postorder(Node node, List<Integer> result) {
        if (node == null){
            return;
        }
        for (Node childNode : node.children) {
            postorder(childNode,result);
        }
        result.add(node.val);
    }
}
