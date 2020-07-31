package com.xm.jy.leetcode.data_structure;

/**
 * @author: albert.fang
 * @date: 2020/7/24 15:25
 * @description: 树的节点
 */
public class TreeNode {
    public int val;
    public TreeNode right;
    public TreeNode left;

    public TreeNode(int val){
        this.val = val;
        this.right = null;
        this.left = null;
    }
}
