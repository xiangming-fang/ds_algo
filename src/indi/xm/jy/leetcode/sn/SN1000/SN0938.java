package indi.xm.jy.leetcode.sn.SN1000;

import indi.xm.jy.leetcode.data_structure.TreeNode;

import java.util.ArrayList;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0938
 * @Author: albert.fang
 * @Description: 二叉搜索树的范围和
 * @Date: 2021/9/28 14:17
 */
public class SN0938 {
    private int res;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrder(root,low,high);
        return res;
    }

    private void inOrder(TreeNode node,int low,int high){
        if (node == null){
            return;
        }
        inOrder(node.left,low,high);
        if (node.val >= low && node.val <= high){
            res += node.val;
        }
        inOrder(node.right,low,high);
    }
}
