package indi.xm.ds_algo.leetcode.sn.SN0200;

import indi.xm.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2020/11/3 15:40
 * @description: 54. 二叉搜索树的第k大节点
 */
public class SN0054 {
    public int kthLargest(indi.xm.data_structure.TreeNode root, int k) {
        List<Integer> ret = new ArrayList<>();
        inOrder(root,ret);
        return ret.get(ret.size() - k + 1);
    }

    private void inOrder(TreeNode node, List<Integer> ret) {
        if (node == null)
            return;
        inOrder(node.left,ret);
        ret.add(node.val);
        inOrder(node.right,ret);
    }
}
