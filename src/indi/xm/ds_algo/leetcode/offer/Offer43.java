package indi.xm.ds_algo.leetcode.offer;

import indi.xm.data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.offer
 * @ClassName: Offer43
 * @Author: albert.fang
 * @Description: 往完全二叉树添加节点
 * @Date: 2021/11/26 15:09
 */
public class Offer43 {

    private class CBTInserter {

        private TreeNode root;
        public CBTInserter(TreeNode root) {
            this.root = root;
        }

        // 实现这个方法才是最关键的
        // 其关键思路就是bfs（广度优先遍历）
        public int insert(int v) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if (poll != null){
                    // 关键思想：层次遍历，不停的搜索，第一个没有左孩子的节点，新加的节点衔接在其左孩子位置
                    if (poll.left == null){
                        poll.left = new TreeNode(v);
                        return poll.val;
                    }
                    // 关键思想：层次遍历，不停的搜索，第一个没有右孩子的节点，新加的节点衔接在其右孩子位置
                    else if (poll.right == null){
                        poll.right = new TreeNode(v);
                        return poll.val;
                    }
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            // 返回-1表示出错了
            return -1;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
