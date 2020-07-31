package com.xm.jy.leetcode.finished.tree;

import com.xm.jy.leetcode.data_structure.TreeNode;

/**
 * @author: albert.fang
 * @date: 2020/7/24 17:34
 * @description: 104. 二叉树的最大深度
 */
public class LeetCode_39 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
