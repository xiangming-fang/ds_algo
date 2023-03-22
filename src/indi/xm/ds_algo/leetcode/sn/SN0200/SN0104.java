package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.data_structure.TreeNode;

/**
 * @author: albert.fang
 * @date: 2020/7/24 17:34
 * @description: 104. 二叉树的最大深度
 */
public class SN0104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
