package indi.xm.jy.leetcode.sn.SN0400;


import indi.xm.jy.leetcode.data_structure.TreeNode;

// 同236
public class SN0235 {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        TreeNode ret;


        // 判断这个节点是否包含p、q
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int a = dfs1(root,p,q);
            return ret;
        }

        private int dfs1(TreeNode node, TreeNode p, TreeNode q){
            if (node == null){
                return 0;
            }
            int left =  dfs1(node.left,p,q);
            int right = dfs1(node.right,p,q);
            int self = node == p || node == q ? 1 : 0;

            if (left + right + self == 2 && ret == null) {
                ret = node;
            }
            return left + right + self;
        }
    }

}
