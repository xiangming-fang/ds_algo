package com.xm.jy.leetcode.doing;

import com.xm.jy.leetcode.data_structure.TreeNode;

import java.util.List;

/**
 * @author: albert.fang
 * @date: 2020/7/27 16:26
 * @description: 257. 二叉树的所有路径
 * @description: 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class LeetCode_52 {
    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }

    public String getPath(TreeNode root,String path){
        while (root.right != null || root.left != null){
            path += root.val;
        }
        return null;
    }
}
