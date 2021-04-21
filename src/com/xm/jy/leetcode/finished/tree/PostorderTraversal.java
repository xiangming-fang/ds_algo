package com.xm.jy.leetcode.finished.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2021/4/14 15:37
 * @description: 145. 二叉树的后序遍历
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root,result);
        return result;
    }

    public void postorderTraversal(TreeNode root,List<Integer> result){
        if (root == null){
            return;
        }
        postorderTraversal(root.left,result);
        postorderTraversal(root.right,result);
        result.add(root.val);
    }
}
