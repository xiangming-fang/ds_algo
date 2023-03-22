package indi.xm.ds_algo.leetcode.offer;

import indi.xm.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.offer
 * @ClassName: Offer46
 * @Author: albert.fang
 * @Description: 二叉树的右侧视图
 * @Date: 2021/11/26 15:35
 */
public class Offer46 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            // 存储当前遍历层的所有节点值
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null){
                    level.add(poll.val);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            if (!level.isEmpty()){
                // 得到当前层最右边的一个节点值
                res.add(level.get(level.size() - 1));
            }
        }
        return res;
    }
}
