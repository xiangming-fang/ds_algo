package indi.xm.jy.leetcode.sn.SN0200;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0129
 * @Author: albert.fang
 * @Description: 求根节点到叶节点数字之和
 * @Date: 2021/11/26 15:48
 */
public class SN0129 {

    int res = 0;

    public int sumNumbers(TreeNode root) {
        backtracking(root,new StringBuilder());
        return res;
    }

    private void backtracking(TreeNode node, StringBuilder path) {
        if (node == null){
            // 随便追加什么字符，只是为了方便统一回溯
            path.append("0");
            return;
        }
        path.append(node.val);
        if (node.left == null && node.right == null){
            res += Integer.parseInt(path.toString());
            return;
        }
        backtracking(node.left,path);
        path.deleteCharAt(path.length() - 1);
        backtracking(node.right,path);
        path.deleteCharAt(path.length() - 1);
    }
}
