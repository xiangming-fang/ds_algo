package indi.xm.jy.leetcode.sn.SN0600;

import indi.xm.jy.leetcode.data_structure.TreeNode;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0671
 * @Author: albert.fang
 * @Description: 二叉树中第二小的节点
 * @Date: 2021/8/25 17:26
 */
public class SN0671 {

    int rs;
    int rootValue;

    // 第二小元素
    public int findSecondMinimumValue(TreeNode root) {
        rs = -1;
        rootValue = root.val;
        dfs(root);
        return rs;
    }

    private void dfs(TreeNode node){
        if (node == null){
            return;
        }
        if (rs != -1 && node.val > rs){
            return;
        }
        if (node.val > rootValue){
            rs = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }



}
