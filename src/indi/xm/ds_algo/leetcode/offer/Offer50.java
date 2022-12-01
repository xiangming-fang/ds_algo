package indi.xm.ds_algo.leetcode.offer;

import indi.xm.ds_algo.leetcode.data_structure.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.offer
 * @ClassName: Offer50
 * @Author: albert.fang
 * @Description: 向下的路径节点之和
 * @Date: 2021/11/26 15:59
 */
public class Offer50 {

    // 思路
    // 1、写一个辅助方法：该方法主要负责从指定节点到叶子节点之间节点总和为targetSum的路径个数
    // 2、遍历一遍这棵树，将这个树的每个节点都放入辅助方法中
    public int pathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum);
    }

    private int dfs(TreeNode node, int targetSum) {
        int res = 0;
        res += curNodeCount(node,targetSum);
        if (node != null){
            res += dfs(node.left,targetSum) ;
            res += dfs(node.right,targetSum);
        }
        return res;
    }

    // 辅助方法：该方法主要负责从指定节点到叶子节点之间节点总和为targetSum的路径个数
    // 这条路径从node开始
    private int curNodeCount(TreeNode node,int targetSum){
        int count = 0;
        if (node == null){
            return count;
        }
        if (targetSum - node.val == 0){
            count ++;
        }
        count += curNodeCount(node.left,targetSum - node.val);
        count += curNodeCount(node.right,targetSum - node.val);
        return count;
    }
}
