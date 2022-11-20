package indi.xm.jy.competition.weekcompetition.th320.sn2;

import indi.xm.jy.leetcode.data_structure.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * t2
 */
public class Solution2 {

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
                dfs(root,query);
                map.put(query, new Pair<>(min, max));
                res.add(Stream.of(min, max).collect(Collectors.toList()));
            }
        }
        return res;
    }

    public void dfs(TreeNode node,int target){
        if (node == null) return;
        if (node.val  == target){
            min  = node.val;
            max = node.val;
            return;
        }
        if (node.val < target) {
            min = node.val;
            dfs(node.right,target);
        }
        max = node.val;
        dfs(node.left,target);
    }

}
