package indi.xm.jy.leetcode.offer;

import indi.xm.jy.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.offer
 * @ClassName: Offer34
 * @Author: albert.fang
 * @Description: 二叉树中和为某一值的路径
 * @Date: 2021/11/26 14:54
 */
public class Offer34 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backtracking(root,target,new ArrayList<Integer>());
        return res;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null){
            // 加入任意值，目的是为了方便进行统一回溯
            path.add(-1);
            return;
        }
        path.add(node.val);
        // 找到叶子节点 & 路径和为 target
        if (node.left == null && node.right == null && getSum(path) == target){
            res.add(new ArrayList<>(path));
            return;
        }
        // 找到叶子节点
        if (node.left == null && node.right == null){
            return;
        }
        backtracking(node.left,target,path);
        path.remove(path.size() - 1);
        backtracking(node.right,target,path);
        path.remove(path.size() - 1);
    }

    private int getSum(ArrayList<Integer> path){
        int res = 0;
        for (Integer ans : path) {
            res += ans;
        }
        return res;
    }
}
