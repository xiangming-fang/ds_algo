package indi.xm.ds_algo.leetcode.sn.SN0200;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0285
 * @Author: albert.fang
 * @Description: 二叉搜索树中的中序后继：这道题是需要VIP的，可是在OfferII:053里面是可以做的，是同一个题目
 * @Date: 2021/11/26 17:03
 */
public class SN0285 {

    TreeNode res = null;

    // 思路：
    // （1）二叉搜索树的中序遍历是保证有序的
    // （2）那么我通过中序遍历整棵树，找到<b>第一个</b>大于 目标节点（p）的节点
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root,p);
        return res;
    }

    // true - 已经找到第一个大于目标节点p的节点了
    // false - 没有找到，需要继续
    private boolean inOrder(TreeNode node, TreeNode p) {
        if (node == null){
            return false;
        }
        if (inOrder(node.left,p)){
            return true;
        }
        if (node.val > p.val ){
            res = node;
            return true;
        }
        if (inOrder(node.right,p)){
            return true;
        }
        return false;
    }
}
