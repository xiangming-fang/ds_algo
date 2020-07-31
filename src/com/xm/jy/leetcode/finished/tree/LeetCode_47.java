package com.xm.jy.leetcode.finished.tree;

import com.xm.jy.leetcode.data_structure.TreeNode;

import java.util.ArrayList;

/**
 * @author: albert.fang
 * @date: 2020/7/27 11:50
 * @description: 872. 叶子相似的树
 * @description: 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 */
public class LeetCode_47 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        getLeafNodeVal(root1,list1);
        getLeafNodeVal(root2,list2);
        return list1.equals(list2);
    }

    public void getLeafNodeVal(TreeNode node,ArrayList<Integer> arrayList){
        if (node != null){
            if (node.left == null && node.right == null){
                arrayList.add(node.val);
            }
            getLeafNodeVal(node.left,arrayList);
            getLeafNodeVal(node.right,arrayList);
        }
    }


}
