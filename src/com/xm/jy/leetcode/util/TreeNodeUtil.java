package com.xm.jy.leetcode.util;

import com.xm.jy.leetcode.data_structure.TreeNode;

import java.util.ArrayList;

/**
 * @author: albert.fang
 * @date: 2020/7/27 14:48
 * @description: 二叉树的工具类
 */
public class TreeNodeUtil {
    /**
     * 根据传进来的一个数组，按顺序生成一颗二叉树
     * @param ants
     * @return
     */
    public static TreeNode generateTreeNode(Integer[] ants){
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        // 创建出对应多的二叉树节点
        for (int i = 0; i < ants.length; i++) {
            if (ants[i] != null){
                TreeNode node = new TreeNode(ants[i]);
                treeNodes.add(node);
            }else if (ants[i] == null){
                treeNodes.add(null);
            }
        }
        for (int j = 0; j < treeNodes.size(); j++) {
            if (treeNodes.get(j) != null){
                if (2 * j + 1 <= treeNodes.size() - 1){
                    treeNodes.get(j).left = treeNodes.get(2 * j + 1);
                }
                if (2 * j + 2 <= treeNodes.size() - 1){
                    treeNodes.get(j).right = treeNodes.get(2 * j + 2);
                }
            }
        }
        // TODO 未完善，有缺陷，暂时只对满二叉树的生成才是正确的
        return treeNodes.get(0);
    }

    public static void main(String[] args) {
        TreeNode node = generateTreeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
    }
}
