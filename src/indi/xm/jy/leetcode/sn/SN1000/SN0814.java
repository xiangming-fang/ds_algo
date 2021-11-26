package indi.xm.jy.leetcode.sn.SN1000;

import indi.xm.jy.leetcode.data_structure.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0814
 * @Author: albert.fang
 * @Description: 二叉树剪枝
 * @Date: 2021/11/26 14:02
 */
public class SN0814 {

    // 思路
    // 1、写一个辅助方法，判断以该节点为根的数是否包含节点值1
    // 2、遍历整个root
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (!isContainOne(node)){
            return null;
        }
        if (!isContainOne(node.left)){
            node.left = null;
        }
        if (!isContainOne(node.right)){
            node.right = null;
        }
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        return node;
    }

    // 判断节点node是否包含值为1的节点
    // 包含返回true 不包含返回false
    private boolean isContainOne(TreeNode node){
        if (node == null){
            return false;
        }
        if (node.val == 1){
            return true;
        }
        return isContainOne(node.left) || isContainOne(node.right);
    }
}
