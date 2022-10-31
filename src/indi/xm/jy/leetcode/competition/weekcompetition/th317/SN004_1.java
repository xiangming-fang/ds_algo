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
public class SN004_1 {

    // 1、寻找重链元素
    // 2、如果查找的元素不在重链中，则不影响原先高度
    // 3、
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] answer = new int[queries.length];
        ArrayList<Integer> heavyNodes = new ArrayList<>();
        // key -> 节点值; value -> 节点高度、整个节点。
        HashMap<Integer, Pair<Integer,TreeNode>> nodeHeightMap = new HashMap<>();
        // key -> 节点值; value -> 对应的父亲节点值
        HashMap<Integer, Integer> nodeParent = new HashMap<>();
        int rootH = findHeavyNodes(root, heavyNodes,nodeHeightMap,nodeParent);
        nodeHeightMap.put(root.val,new Pair<>(rootH,root));
        for (int i = 0; i < queries.length; i++) {
            if (!heavyNodes.contains(queries[i])) answer[i] = rootH - 1;
            else {
                int start = queries[i],max = 0;
                Pair<Integer, TreeNode> parentNode = nodeHeightMap.get(nodeParent.get(start));
                if (parentNode.getValue().right != null && parentNode.getValue().right.val != start) {
                    max = nodeHeightMap.get(parentNode.getValue().right.val).getKey();
                }else if (parentNode.getValue().left != null && parentNode.getValue().left.val != start){
                    max = nodeHeightMap.get(parentNode.getValue().left.val).getKey();
                }
                while (nodeParent.get(start) != null){
                    max ++;
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
}
