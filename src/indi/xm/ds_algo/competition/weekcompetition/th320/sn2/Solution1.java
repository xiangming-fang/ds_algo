package indi.xm.ds_algo.competition.weekcompetition.th320.sn2;

import indi.xm.data_structure.TreeNode;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * t2
 */
public class Solution1 {

    public int max = -1,min = -1;

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        for (int query : queries) {
            if (map.containsKey(query)) {
                min = map.get(query).getKey();
                max = map.get(query).getValue();
                res.add(Stream.of(min, max).collect(Collectors.toList()));
            } else {
                max = -1;
                min = -1;
                min = minDfs(root, query);
                if (min == query) max = min;
                else max = maxDfs(root, query);
                map.put(query, new Pair<>(min, max));
                res.add(Stream.of(min, max).collect(Collectors.toList()));
            }
        }
        return res;
    }



    public int minDfs(TreeNode node,int target){
        if (node == null) return min;
        if (node.val == target) return node.val;
        if (node.val < target) {
            min = node.val;
            return minDfs(node.right,target);
        }
        return minDfs(node.left,target);
    }


    public int maxDfs(TreeNode node,int target){
        if (node == null) return max;
        if (node.val == target) return node.val;
        if (node.val > target) {
            max = node.val;
            return maxDfs(node.left,target);
        }
        return maxDfs(node.right, target);
    }



}
