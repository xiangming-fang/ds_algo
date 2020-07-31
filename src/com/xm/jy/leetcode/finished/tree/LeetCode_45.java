package com.xm.jy.leetcode.finished.tree;

import com.xm.jy.leetcode.data_structure.TreeNode;

/**
 * @author: albert.fang
 * @date: 2020/7/27 10:39
 * @description: 108. 将有序数组转换为二叉搜索树
 * @description: 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class LeetCode_45 {
    // BST是二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return highBalance(nums,0,nums.length - 1);
    }
    // 分析思路，二叉搜索树的中序遍历就是按从小到大的顺序排列的
    // 又因为是高度平衡，每个节点的左右子树深度差不能超过1，所以将中点作为根节点，然后不断遍历左右子树（每个父亲节点都为相应区间的中心节点）
    public TreeNode highBalance(int[] ints,int startIndex,int endIndex){
        if (startIndex > endIndex){
            return null;
        }
        int mid = (startIndex + endIndex)/2;
        TreeNode treeNode = new TreeNode(ints[mid]);
        treeNode.left = highBalance(ints,startIndex,mid - 1);
        treeNode.right = highBalance(ints,mid + 1,endIndex);
        return treeNode;
    }
}
