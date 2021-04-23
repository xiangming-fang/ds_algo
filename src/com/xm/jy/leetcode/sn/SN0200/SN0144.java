package com.xm.jy.leetcode.sn.SN0200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2021/4/14 15:01
 * @description: 144. 二叉树的前序遍历
 */
public class SN0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root,result);
        return result;
    }

    public void preorderTraversal(TreeNode root,List<Integer> result){
        if (root == null){
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left,result);
        preorderTraversal(root.right,result);
    }
}
