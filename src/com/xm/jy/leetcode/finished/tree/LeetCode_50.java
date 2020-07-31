package com.xm.jy.leetcode.finished.tree;

import com.xm.jy.leetcode.data_structure.TreeNode;
import com.xm.jy.test.api.A;

import java.util.ArrayList;

import static com.xm.jy.leetcode.util.TreeNodeUtil.generateTreeNode;

/**
 * @author: albert.fang
 * @date: 2020/7/27 14:27
 * @description: 112. 路径总和
 * @description: 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class LeetCode_50 {
    /**
     * 问题可转化为：叶子节点到根节点的左右节点的和是否为sum - root.val;
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }

}
