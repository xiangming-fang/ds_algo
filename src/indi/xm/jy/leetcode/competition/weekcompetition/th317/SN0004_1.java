package indi.xm.jy.leetcode.competition.weekcompetition.th317;

import indi.xm.jy.leetcode.data_structure.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th317
 * @ClassName: SN004_1
 * @Author: albert.fang
 * @Description: 去掉子树之后的高度
 * @Date: 2022/10/31 13:41
 */
public class SN0004_1 {

    // 1、寻找重链元素
    // 2、如果查找的元素不在重链中，则不影响原先高度
    // 3、如果查找的元素中在重链中，但是还有和这个元素所处一样高度的，则不影响原先高度
    // 4、影响原先高度，现在高度变成当前元素所处高度和父亲节点的另一边儿子高度，比较谁大谁小，一直往上迭代到根节点。
    // 思路没问题，写法有问题，还是tle了
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] answer = new int[queries.length];
        ArrayList<Integer> heavyNodes = new ArrayList<>();
        // key -> 节点值; value -> 节点高度、整个节点。
        HashMap<Integer, Pair<Integer,TreeNode>> nodeHeightMap = new HashMap<>();
        // key -> 节点值; value -> 对应的父亲节点值
        HashMap<Integer, Integer> nodeParent = new HashMap<>();
        int rootH = findHeavyNodes(root, heavyNodes,nodeHeightMap,nodeParent);
        nodeHeightMap.put(root.val,new Pair<>(rootH,root));
        // Key -> height; value -> cnt;
        HashMap<Integer, Integer> heavyNodeMap = new HashMap<>();
        int[] exist = new int[100010];
        for (Integer heavyNode : heavyNodes) {
            Integer height = nodeHeightMap.get(heavyNode).getKey();
            heavyNodeMap.put(height,heavyNodeMap.getOrDefault(height,0) + 1);
            exist[heavyNode] = 1;
        }
        for (int i = 0; i < queries.length; i++) {
            if (exist[queries[i]] == 0 || heavyNodeMap.get(nodeHeightMap.get(queries[i]).getKey()) > 1) answer[i] = rootH - 1;
            else {
                int start = queries[i],max = 0;
                while (nodeParent.get(start) != null){
                    Pair<Integer, TreeNode> parentNode = nodeHeightMap.get(nodeParent.get(start));
                    int level = 0;
                    if (parentNode.getValue().right != null && parentNode.getValue().right.val != start) {
                        level = nodeHeightMap.get(parentNode.getValue().right.val).getKey();
                    }else if (parentNode.getValue().left != null && parentNode.getValue().left.val != start){
                        level = nodeHeightMap.get(parentNode.getValue().left.val).getKey();
                    }
                    max = Math.max(max+1,level + 1);
                    start = nodeParent.get(start);
                }
                answer[i] = max - 1;
            }
        }

        return answer;
    }

    private int findHeavyNodes(TreeNode node, ArrayList<Integer> heavyNodes,
                               HashMap<Integer, Pair<Integer,TreeNode>> nodeHeightMap,
                               HashMap<Integer, Integer> nodeParent) {
        if (node == null) return 0;
        heavyNodes.add(node.val);
        int lh = treeHeight(node.left);
        if (node.left != null) {
            nodeHeightMap.put(node.left.val,new Pair<>(lh,node.left));
            nodeParent.put(node.left.val,node.val);
        }
        int rh = treeHeight(node.right);
        if (node.right != null) {
            nodeHeightMap.put(node.right.val,new Pair<>(rh,node.right));
            nodeParent.put(node.right.val,node.val);
        }
        if ( lh > rh ) findHeavyNodes(node.left,heavyNodes,nodeHeightMap,nodeParent);
        else if (lh < rh) findHeavyNodes(node.right,heavyNodes,nodeHeightMap,nodeParent);
        else {
            findHeavyNodes(node.left,heavyNodes,nodeHeightMap,nodeParent);
            findHeavyNodes(node.right,heavyNodes,nodeHeightMap,nodeParent);
        }
        return Math.max(lh,rh) + 1;
    }

    private int treeHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(1+treeHeight(node.left),1+treeHeight(node.right));
    }

//    [5,4,6,2,null,null,8,1,3,7]
//    [8]

//    [8,6,37,3,7,33,65,1,4,null,null,29,36,51,66,null,2,null,5,26,31,35,null,45,58,null,null,null,null,null,null,22,28,30,32,34,null,44,47,55,59,21,25,27,null,null,null,null,null,null,null,41,null,46,48,54,56,null,62,13,null,24,null,null,null,38,42,null,null,null,49,53,null,null,57,60,64,11,20,23,null,null,39,null,43,null,50,52,null,null,null,null,61,63,null,10,12,18,null,null,null,null,40,null,null,null,null,null,null,null,null,null,null,9,null,null,null,16,19,null,null,null,null,15,17,null,null,14]
//            [57,7,32,55,20,25,45,34,5,19,45,30,48,1,47,32,60,31,22,15,31]

}
