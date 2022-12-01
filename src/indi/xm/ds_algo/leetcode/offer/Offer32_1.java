package indi.xm.ds_algo.leetcode.offer;

import indi.xm.ds_algo.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.offer
 * @ClassName: Offer32_1
 * @Author: albert.fang
 * @Description: 从上到下打印二叉树
 * @Date: 2021/11/26 14:20
 */
public class Offer32_1 {
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll != null){
                queue.offer(poll.left);
                queue.offer(poll.right);
                res.add(poll.val);
            }
        }
        int[] finalRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }
}
