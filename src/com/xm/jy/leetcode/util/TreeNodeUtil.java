package com.xm.jy.leetcode.util;

import com.xm.jy.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2020/7/27 14:48
 * @description: 二叉树的工具类
 */
public class TreeNodeUtil {

    public static TreeNode generateSimpleTree(List<Integer> ants){
        TreeNode root = new TreeNode(ants.get(0));
        generateSimpleTree(root,ants,0);
        return root;
    }

    /**
     * 层序拼接
     * @param ants
     * @return
     */
    public static void generateSimpleTree(TreeNode node, List<Integer> ants, int index){
        if (index > ants.size() - 1){
            return;
        }
        if (node == null){
            return;
        }
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        TreeNode leftNode = leftIndex + 1 > ants.size() ? null : new TreeNode(ants.get(leftIndex));
        TreeNode rightNode = rightIndex + 1 > ants.size() ? null : new TreeNode(ants.get(rightIndex));
        node.left = leftNode;
        generateSimpleTree(node.left,ants,leftIndex);
        node.right = rightNode;
        generateSimpleTree(node.right,ants,rightIndex);
    }

    public static void main(String[] args) {
    }
}
