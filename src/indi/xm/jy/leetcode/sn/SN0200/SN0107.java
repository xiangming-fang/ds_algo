package indi.xm.jy.leetcode.sn.SN0200;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0107
 * @Author: albert.fang
 * @Description: 二叉树的层序遍历 II
 * @Date: 2021/11/26 9:52
 */
public class SN0107 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(res);
        return res;
    }
}
