package indi.xm.ds_algo.leetcode.sn.SN1000;

import indi.xm.ds_algo.leetcode.data_structure.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0700
 * @Author: albert.fang
 * @Description: 二叉搜索树中的搜索
 * @Date: 2021/11/26 9:28
 */
public class SN0700 {

    public TreeNode searchBST(TreeNode root, int val) {
        return traverse(root,val);
    }

    private TreeNode traverse(TreeNode node, int target) {
        if (node == null){
            return node;
        }
        if (node.val == target){
            return node;
        }
        else if (node.val < target){
            return traverse(node.right,target);
        }
        else {
            return traverse(node.left,target);
        }
    }
}
