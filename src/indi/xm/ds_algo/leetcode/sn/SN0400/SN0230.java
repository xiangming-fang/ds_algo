package indi.xm.ds_algo.leetcode.sn.SN0400;

import indi.xm.data_structure.TreeNode;
import indi.xm.data_structure.array.Array;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0230
 * @Author: albert.fang
 * @Description: 二叉搜索树中第K小的元素
 * @Date: 2021/8/25 17:18
 */
public class SN0230 {
    public int kthSmallest(TreeNode root, int k) {
        Array<Integer> array = new Array<>();
        inorder(root,array,k);
        return array.get(k-1);
    }

    private void inorder(TreeNode node, Array<Integer> array,int k){
        if (node == null){
            return;
        }
        inorder(node.left,array,k);
        array.addLast(node.val);
        if (array.getSize() == k){
            return;
        }
        inorder(node.right,array,k);
    }
}
