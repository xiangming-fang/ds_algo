package indi.xm.ds_algo.competition.weekcompetition.th317;

import indi.xm.data_structure.TreeNode;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th317
 * @ClassName: SN0004_2
 * @Author: albert.fang
 * @Description: 去掉子树之后的高度
 * @Date: 2022/11/1 14:01
 */
public class SN0004_2 {

    int N = 100010;

    // 每个节点对应的左右两个孩子 0-> 左孩子值，1-> 右孩子值
    int[][] nodeSons = new int[N][2];
    // 初始化为-1，如果数组中的值为非-1
    // 如果值为非-1,那么肯定当前节点肯定是重链节点，0 表示 当前节点的左节点也是重链节点 1 表示当前节点的右节点是重链节点
    // 注意：最后一个重链节点存的也是-1，因为最后一个重链节点的左右子树高度是一样的。
    int[] heavyNode = new int[N];
    // 每个节点对应的高度
    int[] nodeHeight = new int[N];
    // 删除每一个节点值之后对应的高度
    int[] answers = new int[N];

    public int[] treeQueries(TreeNode root, int[] queries) {
        Arrays.fill(heavyNode,-1);
        dfs(root);

        Arrays.fill(answers,nodeHeight[root.val]);

        int max = 0,height = 0,cur = root.val;
        while (heavyNode[cur] != -1){
            height ++;
            int k = heavyNode[cur];
            max = Math.max(max,nodeHeight[nodeSons[cur][k ^ 1]] + height);
            answers[nodeSons[cur][k]] = max;
            // 下一个重链节点
            cur = nodeSons[cur][k];
        }

        // 到这里已经完整的组装好answers数组了，所以只需遍历queries对应答案即可了。
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = answers[queries[i]] - 1;
        }
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        if (node.left != null) nodeSons[node.val][0] = node.left.val;
        if (node.right != null) nodeSons[node.val][1] = node.right.val;
        int l = dfs(node.left);
        int r = dfs(node.right);
        if (l > r) heavyNode[node.val] = 0;
        else if (r > l) heavyNode[node.val] = 1;
        return nodeHeight[node.val] = Math.max(l,r) + 1;
    }


}
