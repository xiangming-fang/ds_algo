package indi.xm.ds_algo.leetcode.offer;

import indi.xm.data_structure.TreeNode;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.offer
 * @ClassName: Offer32_3
 * @Author: albert.fang
 * @Description: 从上到下打印二叉树 III
 * @Date: 2021/11/26 14:35
 */
public class Offer32_3 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int height = 0;
        while (!queue.isEmpty()){

            int len = queue.size();
            ArrayList<Integer> single = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                if (poll != null){
                    single.add(poll.val);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            // height 是偶数，那么从左向右
            if (!single.isEmpty() && (height & 1) == 0){
                res.add(single);
            }
            // height 是奇数，那么要将该层的遍历结果翻转一下，以到达从左向右的目的
            else if (!single.isEmpty() && (height & 1) == 1){
                Collections.reverse(single);
                res.add(single);
            }
            // 改成遍历结束，要向下一层递进了
            height ++;
        }
        return res;
    }

}
