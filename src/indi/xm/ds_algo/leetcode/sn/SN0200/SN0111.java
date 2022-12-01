package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.ds_algo.leetcode.data_structure.TreeNode;

/**
 * @author: albert.fang
 * @date: 2020/7/24 17:40
 * @description: 111. 二叉树的最小深度
 */
public class SN0111 {
    // 这里需要注意的是不能像求二叉树最大深度那样简单的递归了，一棵树是两个节点的话，那么这棵树深度是2，而不是1。
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null & root.right == null){
            return 1;
        }
        if (root.left == null & root.right != null){
            return minDepth(root.right) + 1;
        }
        if (root.right == null & root.left != null){
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }

    public int minDepth02(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null){
            return 0;
        }
        // 只有左右子树都为空才是高度
        if (node.left == null && node.right == null){
            return 1;
        }
        if (node.left == null){
            return dfs(node.right) + 1;
        }
        if (node.right == null){
            return dfs(node.left) + 1;
        }
        return Math.min(dfs(node.left),dfs(node.right)) + 1;
    }
}
