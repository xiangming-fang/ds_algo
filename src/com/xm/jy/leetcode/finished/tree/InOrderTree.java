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
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root,result);
        return result;
    }

    public void inorderTraversal(TreeNode root,List<Integer> result) {
        if (root == null){
            return;
        }
        inorderTraversal(root.left,result);
        result.add(root.val);
        inorderTraversal(root.right,result);
    }
}

