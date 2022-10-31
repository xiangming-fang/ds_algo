package indi.xm.jy.leetcode.competition.weekcompetition.th317;

import indi.xm.jy.leetcode.data_structure.Node;
import indi.xm.jy.leetcode.data_structure.TreeNode;

import java.util.Objects;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 移除子树之后的树高度
 * @Date: 2022/10/21 16:26
 */
public class SN0004 {


    // tle
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            TreeNode node = new TreeNode(root.val);
            node = copyNode(root,node);
            removeNode(node,queries[i]);
            answer[i] = countHeight(node) - 1;
        }
        return answer;
    }

    private TreeNode copyNode(TreeNode nodeS,TreeNode node) {
        if (nodeS == null) return null;
        if (nodeS.left != null) node.left = copyNode(nodeS.left,new TreeNode(nodeS.left.val));
        if (nodeS.right != null) node.right = copyNode(nodeS.right,new TreeNode(nodeS.right.val));
        return node;
    }


    private TreeNode removeNode(TreeNode node, int query) {
        if (node == null || node.val == query) return null;
        node.left = removeNode(node.left,query);
        node.right = removeNode(node.right,query);
        return node;
    }

    private int countHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(1 + countHeight(node.left),1 + countHeight(node.right));
    }


}
