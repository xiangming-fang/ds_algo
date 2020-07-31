package com.xm.jy.leetcode.finished.array;

import java.util.Arrays;

/**
 * @author: albert.fang
 * @date: 2020/7/27 10:24
 * @description: 1464. 数组中两元素的最大乘积
 * @description: 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 *
 * 请你计算并返回该式的最大值。
 *
 */
public class LeetCode_41 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
