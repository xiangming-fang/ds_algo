package indi.xm.jy.leetcode.sn.SN0400;

import indi.xm.jy.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0257
 * @Author: albert.fang
 * @Description: 二叉树的所有路径
 * @Date: 2021/11/26 11:09
 */
public class SN0257 {

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        backtracking(root,new ArrayList<String>());
        return res;
    }

    // 回溯
    private void backtracking(TreeNode node, ArrayList<String> single) {
        if (node == null){
            // 这里只是为了方便统一回溯
            single.add(" ");
            return;
        }
        single.add(node.val + "");
        if (node.left == null && node.right == null){
            res.add(parseList(single));
            return;
        }
        backtracking(node.left,single);
        single.remove(single.size() - 1);
        backtracking(node.right,single);
        single.remove(single.size() - 1);
    }

    // 辅助函数 —— 将list的每个元素拼接
    private String parseList(ArrayList<String> single){
        StringBuilder res = new StringBuilder();
        for (String s : single) {
            res.append("->").append(s);
        }
        return res.deleteCharAt(0).deleteCharAt(0).toString();
    }
}
