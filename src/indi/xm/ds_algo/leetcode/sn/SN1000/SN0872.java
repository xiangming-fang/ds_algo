package indi.xm.ds_algo.leetcode.sn.SN1000;

import indi.xm.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: albert.fang
 * @date: 2020/7/27 11:50
 * @description: 872. 叶子相似的树
 * @description: 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * @link: https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class SN0872 {

    /**
     * 遍历两颗树，得到两棵树的叶子节点
     * @param root1
     * @param root2
     * @return
     */
    public boolean solution01(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> res1 = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();
        getLeafNodeVal(root1,res1);
        getLeafNodeVal(root2,res2);
        if (res1.size() != res2.size()) return false;
        for (int i = 0; i < res1.size(); i++) {
            if (res1.get(i).compareTo(res2.get(i)) != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 遍历一棵树，得到顺序叶子节点，另一棵树依次去掉叶子节点
     * TODO：这个为啥提交不通过？？？
     * @param root1
     * @param root2
     * @return
     */
    public boolean solution02(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> res = new ArrayList<>();
        getLeafNodeVal(root1,res);
        Collections.reverse(res);
        removeLeafNodeVal(root2,res);
        return res.size() == 0;
    }

    public void getLeafNodeVal(TreeNode node,ArrayList<Integer> res){
        if (node != null){
            if (node.left == null && node.right == null)
                res.add(node.val);
            getLeafNodeVal(node.left,res);
            getLeafNodeVal(node.right,res);
        }
    }

    public void removeLeafNodeVal(TreeNode node,ArrayList<Integer> res){
        if (node != null){
            if (node.left == null && node.right == null){
                if (node.val.compareTo(res.get(0)) == 0){
                    res.remove(0);
                }
            }
            removeLeafNodeVal(node.right,res);
            removeLeafNodeVal(node.left,res);
        }
    }

    public static void main(String[] args) {

    }


}
