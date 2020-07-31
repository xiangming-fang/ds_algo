package com.xm.jy.leetcode.finished.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2020/7/21 10:05
 * @description: 第95题：不同的二叉搜索树 II
 */
public class LeetCode_6 {
    private static List<TreeNode> ans(int start,int end) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (start > end ){
            treeNodeList.add(null);
            return treeNodeList;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = ans(start,i-1);
            List<TreeNode> right = ans(i+1,end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    treeNodeList.add(root);
                }
            }
        }
        return treeNodeList;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}