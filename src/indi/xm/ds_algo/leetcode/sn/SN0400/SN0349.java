package indi.xm.ds_algo.leetcode.sn.SN0400;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author: albert.fang
 * @date: 2021/4/23 15:52
 * @description: 349. 两个数组的交集
 * @description: 给定两个数组，编写一个函数来计算它们的交集，不包含重复元素
 */
public class SN0349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int value : nums1) {
            set.add(value);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int value : nums2) {
            if (set.contains(value)) {
                list.add(value);
                set.remove(value);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
