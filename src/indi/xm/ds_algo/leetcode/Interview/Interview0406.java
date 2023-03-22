package indi.xm.ds_algo.leetcode.Interview;

import indi.xm.data_structure.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.Interview
 * @ClassName: Interview0406
 * @Author: albert.fang
 * @Description: 后继者
 * @Date: 2021/12/24 19:33
 */
public class Interview0406 {

    TreeNode ret = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root,p);

        return ret;
    }

    private void dfs(TreeNode node, TreeNode target) {

        if (node == null){
            return;
        }

        dfs(node.left,target);
        if (ret == null && node.val > target.val){
            ret = node;
        }

        dfs(node.right,target);

    }

}
