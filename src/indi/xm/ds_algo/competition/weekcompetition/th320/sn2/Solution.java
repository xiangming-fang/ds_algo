package indi.xm.ds_algo.competition.weekcompetition.th320.sn2;

import indi.xm.ds_algo.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * t2
 */
public class Solution {

    // 思路：层序遍历 + 排序
    // 结果tle，忽略了bst的中序遍历特性
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null){
                    nums.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        Collections.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int min,max;
        for (int query : queries) {
            min = -1;max = -1;
            for (int num : nums) {
                if (num <= query) min = num;
                if (num >= query) {
                    max = num;
                    break;
                }
            }
            res.add(Stream.of(min,max).collect(Collectors.toList()));
        }
        return res;
    }



}
