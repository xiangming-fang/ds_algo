package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.data_structure.TreeNode;

/**
 * @author: albert.fang
 * @date: 2020/7/27 16:05
 * @description: 100. 相同的树
 * @description: 给定两个二叉树，编写一个函数来检验它们是否相同。
 * @link: https://leetcode-cn.com/problems/same-tree/
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class SN0100 {
    public static boolean solution01(indi.xm.data_structure.TreeNode p, TreeNode q) {
        if (p == null && q != null){
            return false;
        }
        if (p != null && q == null){
            return false;
        }
        if (p == null){
            return true;
        }
        if (p.val == q.val){
            return solution01(p.left,q.left) && solution01(p.right,q.right);
        }
        return false;
    }
}
