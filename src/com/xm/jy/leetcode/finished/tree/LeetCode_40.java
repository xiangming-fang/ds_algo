package com.xm.jy.leetcode.finished.tree;

import com.xm.jy.leetcode.data_structure.TreeNode;

/**
 * @author: albert.fang
 * @date: 2020/7/24 17:40
 * @description: 111. 二叉树的最小深度
 */
public class LeetCode_40 {
    // 这里需要注意的是不能像求二叉树最大深度那样简单的递归了，一棵树是两个节点的话，那么这棵树深度是2，而不是1。
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null & root.right == null){
            return 1;
        }
        if (root.left == null & root.right != null){
            return minDepth(root.right) + 1;
        }
        if (root.right == null & root.left != null){
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
