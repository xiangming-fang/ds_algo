package indi.xm.jy.leetcode.sn.SN0200;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0114
 * @Author: albert.fang
 * @Description: 二叉树展开为链表
 * @Date: 2021/9/3 16:41
 */
public class SN0114 {

    // 前序遍历 + list
    public void flatten(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        preOrder(root,list);
        TreeNode pre;
        for (int i = 1; i < list.size(); i++) {
            pre = list.get(i - 1);
            pre.right = list.get(i);
            pre.left = null;
        }
    }

    private void preOrder(TreeNode node, List<TreeNode> list){
        if (node == null){
            return;
        }
        list.add(node);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }
}
