package indi.xm.ds_algo.leetcode.sn.SN0600;

import indi.xm.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0538
 * @Author: albert.fang
 * @Description: 把二叉搜索树转换为累加树 和 剑指Offer54II相同
 * @Date: 2021/11/26 17:34
 */
public class SN0538 {

    // 从小到达的节点值
    List<Integer> nodeValues = new ArrayList<Integer>();

    // 从小到达的累加值
    List<Integer> cumulateValues = new ArrayList<Integer>();

    // 节点索引，中序从0开始
    int nodeIndex = 0;

    // 思路
    // 1、抓住题目给的条件,是一棵没有重复元素的BST.
    // 2、抓住BST中序遍历的有序性
    // 3、首先中序遍历一次，得到从小到大的值
    // 4、通过第3步得到的序列记忆化得到每个节点对应的sum值
    // 5、再次遍历整棵树，替换节点对应的累加数
    public TreeNode convertBST(TreeNode root) {
        // 第一步：1、2、3（注释里的步骤）
        inOrder(root);
        // 第二步：4
        setCumulateValues();
        // 第三步：5
        cumulateTree(root);
        return root;
    }

    private void cumulateTree(TreeNode node){
        if (node == null){
            return;
        }
        cumulateTree(node.left);
        node.val = cumulateValues.get(nodeIndex++);
        cumulateTree(node.right);
    }

    private void inOrder(TreeNode node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        nodeValues.add(node.val);
        inOrder(node.right);
    }

    private void setCumulateValues(){
        for (int i = 0; i < nodeValues.size(); i++) {
            cumulateValues.add(getSum(nodeValues.subList(i,nodeValues.size())));
        }
    }

    private int getSum(List<Integer> list){
        int res = 0;
        for (Integer ans : list) {
            res += ans;
        }
        return res;
    }

}
