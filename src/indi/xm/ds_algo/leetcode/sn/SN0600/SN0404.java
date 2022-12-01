package indi.xm.ds_algo.leetcode.sn.SN0600;

import indi.xm.ds_algo.leetcode.data_structure.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: albert.fang
 * @date: 2020/11/3 16:48
 * @description: 404. 左叶子之和（注意是左叶子，并不是说全部的左孩子）
 */
public class SN0404 {
    public static int sumOfLeftLeaves(TreeNode root) {
        AtomicInteger sum = new AtomicInteger(0);
        sumOfLeftLeaves(root, sum);
        return sum.get();
    }

    private static void sumOfLeftLeaves(TreeNode root, AtomicInteger sum) {
        if (root == null)
            return;
        // 该节点存在左叶子节点
        if (root.left != null){
            if (root.left.left == null && root.left.right == null){
                sum.getAndSet(sum.get() + root.left.val);
            }
            sumOfLeftLeaves(root.left,sum);
        }
        if (root.right != null){
            sumOfLeftLeaves(root.right,sum);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        int i = sumOfLeftLeaves(node);
        System.out.println(i);
    }
}
