package com.xm.jy.leetcode.data_structure;

/**
 * @author: albert.fang
 * @date: 2020/7/24 15:25
 * @description: 树的节点
 */
public class TreeNode {
    public Integer val;
    public TreeNode right;
    public TreeNode left;

    public TreeNode(Integer val){
        this.val = val;
        this.right = null;
        this.left = null;
    }

    public TreeNode(Integer val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
