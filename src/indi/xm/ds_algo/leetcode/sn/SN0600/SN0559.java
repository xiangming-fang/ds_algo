package indi.xm.ds_algo.leetcode.sn.SN0600;

import indi.xm.data_structure.N_TreeNode;

/**
 * @author: albert.fang
 * @date: 2020/7/27 13:38
 * @description: 559. N叉树的最大深度
 */
public class SN0559 {
    /**
     * 之前计算二叉树的深度是通过动态规划来解答的，这里其实也是一样的
     * 如果没有子树，返回1
     * 有的话，那么Max(maxDepth(子树1号),maxDepth(子树2号)...子树n) + 1
     * @param root
     * @return
     */
    public int maxDepth(N_TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.children == null){
            return 1;
        }
        int max = 0;
        for (N_TreeNode child : root.children) {
            int tempDepth = maxDepth(child);
            max = Math.max(tempDepth,max);
        }
        return max + 1;
    }
}
