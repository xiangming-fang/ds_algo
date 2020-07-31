package com.xm.jy.leetcode.finished.tree;

import com.xm.jy.leetcode.data_structure.TreeNode;

/**
 * @author: albert.fang
 * @date: 2020/7/24 17:09
 * @description: 101. 对称二叉树
 * @description: 给定一个二叉树，检查它是否是镜像对称的。
 */
public class LeetCode_38 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isImage(root.left,root.right);

    }
    public boolean isImage(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return isImage(left.right,right.left) && isImage(left.left,right.right);
    }
}
