package com.xm.jy.leetcode.data_structure;

import java.util.List;

/**
 * @author: albert.fang
 * @date: 2020/7/27 13:36
 * @description: N叉树
 */
public class N_TreeNode {
    public int val;
    public List<N_TreeNode> children;

    public N_TreeNode() {}

    public N_TreeNode(int _val) {
        val = _val;
    }

    public N_TreeNode(int _val, List<N_TreeNode> _children) {
        val = _val;
        children = _children;
    }
}
