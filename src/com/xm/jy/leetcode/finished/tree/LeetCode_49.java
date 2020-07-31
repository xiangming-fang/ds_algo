package com.xm.jy.leetcode.finished.tree;

import com.xm.jy.leetcode.data_structure.TreeNode;

/**
 * @author: albert.fang
 * @date: 2020/7/27 14:10
 * @description: 面试题 04.02. 最小高度树
 * @description: 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 */
public class LeetCode_49 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }

    public TreeNode helper(int[] nums,int startIndex, int endIndex){
        if (startIndex > endIndex){
            return null;
        }
        int mid = (startIndex + endIndex)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,startIndex,mid - 1);
        root.right = helper(nums,mid + 1,endIndex);
        return root;
    }
}
