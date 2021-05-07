package com.xm.jy.leetcode.sn.SN0200;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author: albert.fang
 * @date: 2021/4/23 16:06
 * @description: 1. 两数之和
 * @description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class SN0001 {
    public int[] twoSum(int[] nums, int target) {
        return solution01(nums,target);
    }

    /**
     * 双重遍历，暴力查找，时间复杂度 O(n^2)
     * @param nums
     * @param target
     * @return
     */
    private int[] solution01(int[] nums, int target) {
        int first,last;
        int[] set = new int[2];
        for (int i = 0; i < nums.length; i++) {
            first = i;
            for (int j = i + 1; j < nums.length; j++) {
                last = j;
                if (nums[first] + nums[last] == target){
                    set[0] = first;
                    set[1] = last;
                }
            }
        }
        return set;
    }

    /**
     * 借用映射这种数据结构
     * 时间复杂度：O(2n) = O(n)
     * @param nums
     * @param target
     * @return
     */
    private int[] solution02(int[] nums, int target){
        // key -> 值，value -> 下标
        TreeMap<Integer,Integer> record = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i],i);
        }
        for (int j = 0; j < nums.length; j++) {
            int temp = target - nums[j];
            if (record.get(temp) != null && record.get(temp) != j){
                return new int[]{j,record.get(temp)};
            }
        }
        throw new RuntimeException("not exists");
    }
}
