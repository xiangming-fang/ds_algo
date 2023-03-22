package indi.xm.ds_algo.leetcode.sn.SN0400;

import indi.xm.data_structure.TreeNode;
import org.junit.Test;

import java.util.Objects;

// 二叉树的最近公共祖先
public class SN0236 {

    TreeNode res;

    // 转化问题为：找到一棵最小的，并且同时包含节点p，q的树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }

    // 是否找到了同时包含p和q的节点了
    // true - 找到了
    // false - 没找到
    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null){
            return false;
        }
        if(dfs(node.left,p,q)){
            return true;
        }
        if(dfs(node.right,p,q)){
            return true;
        }
        if (isContainsNode(node,p) && isContainsNode(node,q)) {
            res = node;
            return true;
        }
        return dfs(node.left,p,q) || dfs(node.right,p,q);
    }

    // node是否包含targetNode节点
    private boolean isContainsNode(TreeNode node,TreeNode targetNode){
        if (node == null){
            return false;
        }
        if (Objects.equals(node.val, targetNode.val)){
            return true;
        }
        return isContainsNode(node.left,targetNode) || isContainsNode(node.right,targetNode);
    }

    TreeNode ret;


    // 判断这个节点是否包含p、q
    public TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q) {
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



    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        System.out.println(lowestCommonAncestor(treeNode, new TreeNode(1), new TreeNode(2)));
//        System.out.println(isContainsNode(treeNode, new TreeNode(2)));
    }

}
