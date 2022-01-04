package indi.xm.jy.leetcode.sn.SN0600;

import indi.xm.jy.leetcode.data_structure.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0617
 * @Author: albert.fang
 * @Description: 合并二叉树
 * @Date: 2021/9/1 18:42
 */
public class SN0617 {

    public TreeNode mergeTrees01(TreeNode root1, TreeNode root2) {
        // 终止条件
        // 1、要合并的两个节点都为null，那么返回null。
        if (root1 == null && root2 == null){
            return null;
        }
        // 2、当第一棵树不为null，第二棵树为null，那么直接返回第一棵树。
        else if (root1 != null && root2 == null){
            return root1;
        }
        // 3、当第一课树为null，第二棵树不为null，那么直接返回第二棵树。
        else if (root1 == null){
            return root2;
        }

        // 4、如果两棵树都不为null，那么将节点值合并，然后将合并之后的值给第一棵树。
        root1.val = root1.val + root2.val;

        // 5、更小问题
        root1.left = mergeTrees01(root1.left,root2.left);
        root1.right = mergeTrees01(root1.right,root2.right);

        return root1;
    }

    /******************* 2022-01-04 **************************/

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1,root2);
    }

    private TreeNode dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return null;
        if (p == null) return q;
        if (q == null) return p;
        p.val = p.val + q.val;
        p.left = dfs(p.left,q.left);
        p.right = dfs(p.right,q.right);
        return p;
    }

}
