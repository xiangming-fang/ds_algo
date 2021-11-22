package indi.xm.jy.leetcode.sn.SN0600;

import java.util.List;

// N 叉树的最大深度
public class SN0559_02 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        return depth(root);
    }

//    private int res = 0;

    // 得到某个节点的高度
    private int depth(Node node) {
        // 空节点 高度为0
        if (node == null){
            return 0;
        }
        int height = 1;
        for (Node child : node.children) {
            height = Math.max(depth(child) + 1,height);
        }

        return height;
    }


}
