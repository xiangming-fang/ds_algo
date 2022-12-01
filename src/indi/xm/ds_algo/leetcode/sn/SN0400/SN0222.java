package indi.xm.ds_algo.leetcode.sn.SN0400;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0222
 * @Author: albert.fang
 * @Description: 完全二叉树的节点个数
 * @Date: 2021/11/25 19:26
 */
public class SN0222 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 方法二：用到了完全二叉树的特性
    // 关键思想：根据一个节点的最左边一条边和最右边的一条边，得到高度差，相等，说明是完全二叉树；
    // 不相等的话，再不停的将其子树进行划分，转为完全二叉树处理。 核心代码：countNodes(node.left) + countNodes(node.right) + 1
    public int countNodes(TreeNode root) {
        if (root == null ){
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        TreeNode tempLeft = root;
        while (tempLeft.left != null){
            tempLeft = tempLeft.left;
            leftHeight ++;
        }
        TreeNode tempRight = root;
        while (tempRight.right != null){
            tempRight = tempRight.right;
            rightHeight ++;
        }
        // 如果是完全二叉树，那么直接根据完全二叉树特定，返回：2^(h+1) - 1 h得从零开始算
        if (leftHeight == rightHeight){
            return (1 << (leftHeight + 1)) - 1;
        }
        // 不停的将子树拆分成完全二叉树
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    // 方法一：没有用到完全二叉树的特性
    private int res = 0;
    public int countNodes01(TreeNode root){
        count(root);
        return res;
    }

    private void count(TreeNode node) {
        if (node == null){
            return;
        }
        res ++;
        countNodes01(node.left);
        countNodes01(node.right);
    }

    // 方法三：没有用到完全二叉树的特性
    public int countNodes03(TreeNode root){
        if (root == null){
            return 0;
        }
        return countNodes03(root.left) + countNodes03(root.right) + 1;
    }

    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
//        treeNode3.left = treeNode6;
        System.out.println(countNodes01(treeNode1));
    }
}
