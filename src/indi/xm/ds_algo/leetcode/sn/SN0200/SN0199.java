package indi.xm.ds_algo.leetcode.sn.SN0200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0199
 * @Author: albert.fang
 * @Description: 二叉树的右视图
 * @Date: 2021/8/25 16:38
 */
public class SN0199 {

    // 层序遍历，每次保留每层的最后一个节点
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            // 每层节点个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                if (i == size - 1){
                    res.add(cur.val);
                }
            }
        }
        return res;
    }
}
