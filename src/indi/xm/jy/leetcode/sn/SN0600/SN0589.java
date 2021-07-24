package indi.xm.jy.leetcode.sn.SN0600;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2021/4/14 15:13
 * @description: 589. N 叉树的前序遍历
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 *
 */
public class SN0589 {

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

    public List<Integer> preorder(Node node) {
        List<Integer> result = new ArrayList<>();
        preorder(node,result);
        return result;
    }

    private void preorder(Node node, List<Integer> result) {
        if (node == null){
            return;
        }
        result.add(node.val);
        for (Node childNode : node.children) {
            preorder(childNode,result);
        }
    }
}
