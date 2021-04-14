package com.xm.jy.leetcode.doing;

import com.xm.jy.leetcode.data_structure.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: albert.fang
 * @date: 2020/11/4 10:50
 * @description: 55 - I. 二叉树的深度
 */
public class MaxDepthOfTree {

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(8);
        node.right.left = new TreeNode(6);
        node.right.left.right = new TreeNode(9);
        node.right.left.right.left = new TreeNode(10);
        node.right.right = new TreeNode(7);
        int i = maxDepth(node);
        System.out.println(i);
    }
}
