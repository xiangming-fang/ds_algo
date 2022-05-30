package indi.xm.jy.leetcode.sn.SN1500;

import indi.xm.jy.leetcode.data_structure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1500
 * @ClassName: SN1022
 * @Author: albert.fang
 * @Description: 1022. 从根到叶的二进制数之和
 * @Date: 2022/5/30 14:04
 */
public class SN1022 {


    List<List<String>> res = new ArrayList<>();

    public int sumRootToLeaf(TreeNode root) {
        backtracking(root, new ArrayList<>());
        return getSum(res);
    }

    private int getSum(List<List<String>> paths){
        int res =  0;
        for (List<String> path : paths) {
            for (int i = 0; i < path.size(); i++) {
                if (Objects.equals(path.get(i), "1")){
                    res += Math.pow(2,(path.size() - 1) - i);
                }
            }
        }
        return res;
    }

    // 回溯
    private void backtracking(TreeNode node, ArrayList<String> path) {
        if (node == null){
            // 这里只是为了方便统一回溯
            path.add(" ");
            return;
        }
        path.add(node.val + "");
        if (node.left == null && node.right == null){
            res.add(new ArrayList<>(path));
            return;
        }
        backtracking(node.left,path);
        path.remove(path.size() - 1);
        backtracking(node.right,path);
        path.remove(path.size() - 1);
    }

    @Test
    public void test(){
        List<List<String>> aa = new ArrayList<>();
        List<String> bb = Stream.of("0","1","1","0","1").collect(Collectors.toList());
        List<String> cc = Stream.of("0","1","1","0","1").collect(Collectors.toList());
        aa.add(bb);
        aa.add(cc);
        System.out.println(getSum(aa));

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(0);
        TreeNode treeNode6 = new TreeNode(1);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        backtracking(treeNode,new ArrayList<>());
        System.out.println(res);
    }

}
