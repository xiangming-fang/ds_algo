package indi.xm.ds_algo.competition.weekcompetition.th320.sn2;

import indi.xm.ds_algo.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * t2
 */
public class Solution2 {

    // 思路：bst的中序遍历 + 二分
    // 1、将bst直接中序遍历，输出结果用nums数组接住。
    // 2、因为nums数组是有序的，所以我们就可以用二分的方法从中找到对应值
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> nums = new ArrayList<>();
        midOrder(root,nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int query : queries) {
            int min = -1,max = -1;
            int l = 0,r = nums.size() - 1;
            // 第一个二分查找小于等于query的最大值
            while (l<r){
                int mid = l + ( r - l + 1)/2;
                // 如果二分的中点小于等于待查找值query，说明待查找元素在右边，所以右移左边界
                if (query >= nums.get(mid)) l = mid;
                else r = mid - 1;
            }
            if (nums.get(l) <= query) min = nums.get(l);
            // 第二个二分查找大于等于query的最小值
            l = 0;r = nums.size() - 1;
            while (l < r){
                int mid = l + (r - l)/2;
                // 如果二分的中点大于等于query，说明待查找元素在左边，左移右边界
                if (query <= nums.get(mid)) r = mid;
                else l = mid + 1;
            }
            if (nums.get(l) >= query) max = nums.get(l);
            res.add(Stream.of(min,max).collect(Collectors.toList()));
        }
        return res;
    }

    public void midOrder(TreeNode node,List<Integer> ans){
        if (node == null) return;
        midOrder(node.left,ans);
        ans.add(node.val);
        midOrder(node.right,ans);
    }

    public static void main(String[] args) {
        System.out.println(-1111%3);
    }



}
