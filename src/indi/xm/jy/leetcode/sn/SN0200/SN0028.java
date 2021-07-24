package indi.xm.jy.leetcode.sn.SN0200;

import indi.xm.jy.leetcode.data_structure.TreeNode;

/**
 * @author: albert.fang
 * @date: 2020/11/4 10:43
 * @description: 28. 对称的二叉树
 */
public class SN0028 {
    public boolean isSymmetric(indi.xm.jy.leetcode.data_structure.TreeNode root) {
        if (root == null)
            return true;
        // 传入一个节点的左右子树
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(indi.xm.jy.leetcode.data_structure.TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
