package com.xm.jy.leetcode.finished.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2020/11/3 15:18
 * @description: 94. 二叉树的中序遍历
 */
public class InOrderTree {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorderTraversal(root,ret);
        return ret;
    }

    private void inorderTraversal(TreeNode node, List<Integer> ret) {
        if (node == null)
            return;
        inorderTraversal(node.left,ret);
        ret.add(node.val);
        inorderTraversal(node.right,ret);
    }
}
