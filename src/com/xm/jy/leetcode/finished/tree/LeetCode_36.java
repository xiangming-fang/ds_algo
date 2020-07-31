package com.xm.jy.leetcode.finished.tree;

import com.xm.jy.leetcode.data_structure.Node;
import com.xm.jy.leetcode.data_structure.TreeNode;

import java.util.HashMap;

/**
 * @author: albert.fang
 * @date: 2020/7/24 15:28
 * @description: 面试题 04.04. 检查平衡性
 * @description: 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 */
public class LeetCode_36 {
    static HashMap<TreeNode,Integer> hashMap = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(getDepth(root.right) - getDepth(root.left)) > 1){
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }

    public int getDepth(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        // 增加记忆
        if (hashMap.containsKey(treeNode)){
            return hashMap.get(treeNode);
        }
        hashMap.put(treeNode,Math.max(getDepth(treeNode.left),getDepth(treeNode.right)) + 1);
        return hashMap.get(treeNode);
    }
}
