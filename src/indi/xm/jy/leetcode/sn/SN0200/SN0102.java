package indi.xm.jy.leetcode.sn.SN0200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0102
 * @Author: albert.fang
 * @Description: 二叉树的层序遍历
 * @Date: 2021/11/26 9:37
 */
public class SN0102 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> single = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                if (poll != null){
                    single.add(poll.val);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            if (!single.isEmpty()){
                res.add(single);
            }
        }
        return res;
    }

}
