package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0113
 * @Author: albert.fang
 * @Description: 路径总和 II
 * @Date: 2021/11/19 15:42
 */
public class SN0113 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root,targetSum,path);
        return res;
    }


    private void dfs(TreeNode node, int targetSum, ArrayList<Integer> path) {
        // 终止条件1：叶子节点 & 路径总和等于目标和
        if (node == null){
            // 非叶子节点的子节点为空，给任意添加一个元素到路径中，任意节点值皆可，目的是为了方便统一回溯
            path.add(-1);
            return;
        }
        path.add(node.val);
        // 终止条件2：叶子节点 & 路径总和等于目标和
        if (node.left == null && node.right == null && getSum(path) == targetSum){
            res.add(new ArrayList<>(path));
            return;
        }
        // 终止条件3：叶子节点
        if (node.left == null && node.right == null){
            return;
        }
        dfs(node.left,targetSum,path);
        path.remove(path.size() - 1);
        dfs(node.right,targetSum,path);
        path.remove(path.size() - 1);
    }

    private int getSum(List<Integer> path){
        int res = 0;
        for (Integer integer : path) {
            res += integer;
        }
        return res;
    }

    @Test
    public void test(){
//        System.out.println(getSum(new ArrayList<Integer>() {{
//            add(5);
//            add(4);
//            add(11);
//            add(7);
//        }}));

        TreeNode node = new TreeNode(1);
        TreeNode tn = new TreeNode(2);
        tn.left = new TreeNode(4);
        tn.right = new TreeNode(5);
        node.left = tn;
        node.right = new TreeNode(3);
        System.out.println(pathSum(null, 4));
    }
}
