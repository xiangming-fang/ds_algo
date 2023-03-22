package indi.xm.ds_algo.leetcode.sn.SN1500;

import indi.xm.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1500
 * @ClassName: SN1305
 * @Author: albert.fang
 * @Description: 两棵二叉搜索树中的所有元素
 * @Date: 2021/9/7 11:54
 */
public class SN1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        inorder(root1,res);
        inorder(root2,res);
        Collections.sort(res);
        return res;
    }

    private void inorder(TreeNode node,List<Integer> res){
        if (node == null){
            return;
        }
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }
}
