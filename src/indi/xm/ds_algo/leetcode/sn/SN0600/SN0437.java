package indi.xm.ds_algo.leetcode.sn.SN0600;

import indi.xm.ds_algo.leetcode.data_structure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0437
 * @Author: albert.fang
 * @Description: 路径总和 III
 * @Date: 2021/9/28 10:03
 */
public class SN0437 {

    private int res;


    public int pathSum(TreeNode root, int targetSum) {
        bfs(root,targetSum);
        return res;
    }

    private void bfs(TreeNode node,int targetSum){
        Queue<TreeNode> queue = new LinkedList<>();
        if (node != null){
            queue.offer(node);
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                nodeSum(poll,targetSum);
            }
        }
    }

    // 这是一个节点到子节点有没有的判断
    private void nodeSum(TreeNode node, int sum) {
        if (node == null){
            return;
        }

        int val = node.val;

        if (val == sum){
            res ++;
        }
        nodeSum(node.left,sum - val);
        nodeSum(node.right,sum - val);
    }

    @Test
    public void test(){
        ArrayList<Integer> helpArray = new ArrayList<>();
//        helpArray.add(23);
//        helpArray.add(23);
        System.out.println(helpArray.stream().mapToInt(Integer::intValue).sum());
    }
}
