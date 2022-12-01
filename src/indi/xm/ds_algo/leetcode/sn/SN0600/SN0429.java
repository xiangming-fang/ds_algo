package indi.xm.ds_algo.leetcode.sn.SN0600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0429
 * @Author: albert.fang
 * @Description: N 叉树的层序遍历
 * @Date: 2021/11/26 10:40
 */
public class SN0429 {

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
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> single = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node poll = queue.poll();
                if (poll != null){
                    single.add(poll.val);
                    for (Node child : poll.children) {
                        queue.offer(child);
                    }
                }
            }
            if (!single.isEmpty()){
                res.add(single);
            }
        }
        return res;
    }
}
