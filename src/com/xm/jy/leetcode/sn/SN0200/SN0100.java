package com.xm.jy.leetcode.sn.SN0200;

import com.xm.jy.leetcode.data_structure.TreeNode;
import com.xm.jy.leetcode.util.TreeNodeUtil;

/**
 * @author: albert.fang
 * @date: 2020/7/27 16:05
 * @description: 100. 相同的树
 * @description: 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class SN0100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }


    public static void main(String[] args) {
        isSameTree(TreeNodeUtil.generateTreeNode(new Integer[]{1,2}),TreeNodeUtil.generateTreeNode(new Integer[]{1,null,2}));
    }
}
