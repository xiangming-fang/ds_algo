package com.xm.jy.leetcode.sn.SN0400;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author: albert.fang
 * @date: 2021/4/23 15:59
 * @description: 350. 两个数组的交集 II
 * @description: 给定两个数组，编写一个函数来计算它们的交集，包含重复元素
 */
public class SN0350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // key -> num,value -> times
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)){
                list.add(num);
                map.put(num,map.get(num) - 1);
                if (map.get(num) == 0){
                    map.remove(num);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
