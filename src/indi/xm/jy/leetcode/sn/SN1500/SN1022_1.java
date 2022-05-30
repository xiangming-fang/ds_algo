package indi.xm.jy.leetcode.sn.SN1500;

import indi.xm.jy.leetcode.data_structure.TreeNode;

import java.util.ArrayList;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1500
 * @ClassName: SN1022_1
 * @Author: albert.fang
 * @Description: 1022. 从根到叶的二进制数之和
 * @Date: 2022/5/30 15:49
 */
public class SN1022_1 {

    public int sumRootToLeaf(TreeNode root) {
        return getSum(root,0);
    }

    private int getSum(TreeNode node,int preSum){
        int ans = 0;
        preSum = (preSum << 1) + node.val;
        if (node.left != null) ans += getSum(node.left,preSum);
        if (node.right != null) ans += getSum(node.right,preSum);
        return node.left == null && node.right == null ? preSum : ans;
    }
}
