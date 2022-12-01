package indi.xm.ds_algo.leetcode.offer;

import indi.xm.ds_algo.leetcode.data_structure.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.offer
 * @ClassName: Offer55_1
 * @Author: albert.fang
 * @Description: 二叉树的深度
 * @Date: 2021/11/26 15:02
 */
public class Offer55_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
