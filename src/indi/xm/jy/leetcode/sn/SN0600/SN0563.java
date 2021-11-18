package indi.xm.jy.leetcode.sn.SN0600;

import indi.xm.jy.leetcode.data_structure.TreeNode;
import indi.xm.jy.leetcode.data_structure.queue.ArrayQueue;
import indi.xm.jy.leetcode.data_structure.queue.Queue;

import java.util.LinkedList;

// 二叉树的坡度
public class SN0563 {
    public int findTilt(TreeNode root) {
        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // while 控制深度
        while (!queue.isEmpty()){
            int len = queue.size();
            // for 控制层遍历
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                if (poll != null){
                    res += Math.abs(getSum(poll.left) - getSum(poll.right));
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }

    private int getSum(TreeNode node){
        int res = 0;
        if (node == null){
            return res;
        }
        res += getSum(node.left);
        res += node.val;
        res += getSum(node.right);
        return res;
    }
}
