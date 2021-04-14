package com.xm.jy.leetcode.doing;

import com.xm.jy.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: albert.fang
 * @date: 2020/11/3 15:49
 * @description: 32 - II. 从上到下打印二叉树 II
 */
public class FromTopToEnd {
    // 其实就是层次遍历，难点：分层次
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            System.out.println(cur.val);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        return null;
    }
}
