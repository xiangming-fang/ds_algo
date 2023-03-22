package indi.xm.ds_algo.leetcode.offer;

import indi.xm.data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.offer
 * @ClassName: Offer45
 * @Author: albert.fang
 * @Description: 二叉树最底层最左边的值
 * @Date: 2021/11/26 15:28
 */
public class Offer45 {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            // 遍历当前层
            int first = 0;
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                if (poll != null){
                    // 当前层从左向右第一个
                    if (first == 0){
                        res = poll.val;
                    }
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                    first ++;
                }
            }
        }
        return res;
    }
}
