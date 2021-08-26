package indi.xm.jy.leetcode.sn.SN0200;

import indi.xm.jy.leetcode.data_structure.array.Array;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0098
 * @Author: albert.fang
 * @Description: 验证二叉搜索树
 * @Date: 2021/8/25 16:56
 */
public class SN0098 {

    public boolean isValidBST(TreeNode root) {
        Array<Integer> array = new Array<>();
        inorder(root,array);
        for (int i = 1; i < array.getSize(); i++) {
            if (array.get(i-1).compareTo(array.get(i)) >= 0){
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode node, Array<Integer> array){
        if (node == null){
            return;
        }
        inorder(node.left,array);
        array.addLast(node.val);
        inorder(node.right,array);
    }
}
