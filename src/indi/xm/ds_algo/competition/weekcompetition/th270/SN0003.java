package indi.xm.ds_algo.competition.weekcompetition.th270;

import indi.xm.ds_algo.leetcode.data_structure.TreeNode;
import org.junit.Test;

// 2096. 从二叉树一个节点到另一个节点每一步的方向
public class SN0003 {

    TreeNode ret;

    boolean findSrc,findDesc;

    public String getDirections(TreeNode root, int startValue, int destValue) {

        // 找到startValue 和 destValue的最近公共祖先 <b>ret</b>
        dfs(root,startValue,destValue);

        StringBuilder path = new StringBuilder();

        findSrc(ret,startValue,path);

        findDesc(ret,destValue,path);

        return path.toString();
    }

    private void findDesc(TreeNode node, int destValue, StringBuilder path) {

            if (node == null){
                path.append(" ");
                return;
            }

            if (node.val == destValue){
                findDesc = true;
                return;
            }

        if (!findDesc) {

            if (node.left != null){
                path.append("L");
                findDesc(node.left,destValue,path);
                if (!findDesc) {
                    path.deleteCharAt(path.length() - 1);
                }
            }
        }
        if (!findDesc) {

            if (node.right != null){
                path.append("R");
                findDesc(node.right,destValue,path);
                if (!findDesc) {
                    path.deleteCharAt(path.length() - 1);
                }
            }

        }


    }

    private void findSrc(TreeNode node,int startValue,StringBuilder path){

        if (node == null){
            return;
        }

        if (node.val == startValue){
            findSrc = true;
            return;
        }

        if (!findSrc){
            path.append("U");
            findSrc(node.left,startValue,path);
            if (!findSrc){
                path.deleteCharAt(path.length() - 1);
            }
        }

        if (!findSrc){
            path.append("U");
            findSrc(node.right,startValue,path);
            if (!findSrc){
                path.deleteCharAt(path.length() - 1);
            }
        }

    }

    // node 节点 包含几个startValue,destValue
    private int dfs(TreeNode node, int startValue, int destValue) {

        if (node == null){
            return 0;
        }

        int left = dfs(node.left,startValue,destValue);
        int right = dfs(node.right,startValue,destValue);
        int self = node.val == startValue || node.val == destValue ? 1 : 0;

        if (ret == null && left + right + self == 2){
            ret = node;
            return 2;
        }

        return left + right + self;
    }

    @Test
    public void test(){

        TreeNode treeNode = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode w = new TreeNode(2);
        TreeNode e = new TreeNode(3);
        TreeNode r = new TreeNode(6);
        TreeNode t = new TreeNode(4);
        treeNode.left = q;
        treeNode.right = w;
        q.left = e;
        w.left = r;
        w.right = t;

        String directions = getDirections(treeNode, 3, 6);
        System.out.println(directions);
    }
}
