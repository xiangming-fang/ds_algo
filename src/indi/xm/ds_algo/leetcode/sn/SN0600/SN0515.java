package indi.xm.ds_algo.leetcode.sn.SN0600;

import indi.xm.data_structure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0515
 * @Author: albert.fang
 * @Description: 在每个树行中找最大值
 * @Date: 2021/11/26 13:05
 */
public class SN0515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            int minValue = Integer.MIN_VALUE;
            // 判断是否有进行比较
            boolean flag = false;
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                if (poll != null){
                    if (!flag){
                        flag = true;
                    }
                    minValue = Math.max(minValue,poll.val);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            if (flag){
                res.add(minValue);
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(largestValues(new TreeNode(-2147483648)));
    }
}
