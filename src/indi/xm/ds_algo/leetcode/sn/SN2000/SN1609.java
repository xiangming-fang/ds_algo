package indi.xm.ds_algo.leetcode.sn.SN2000;


import indi.xm.ds_algo.leetcode.data_structure.TreeNode;
import java.util.LinkedList;
// 1609.奇偶性
public class SN1609 {


    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level= 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            level ++;
            int pre;
            if ((level & 1) == 0)  pre = Integer.MAX_VALUE;
            else pre = Integer.MIN_VALUE;

            for (int i = 0; i < len; i++) {

                TreeNode poll1 = queue.poll();
                if (poll1 != null ){
                    int cur = poll1.val;
                    if ((level & 1) == 0) {
                    if (( cur & 1) == 1 || pre <= cur) return false;

                }
                else {
                    if (( cur & 1) == 0 || pre >= cur) return false;
                }
                    pre = cur;

                    queue.offer(poll1.left);
                    queue.offer(poll1.right);
                }
            }
        }
        return true;
    }


}
