package com.xm.jy.leetcode.finished.array;

/**
 * @author: albert.fang
 * @date: 2020/7/27 10:03
 * @description: 1470. 重新排列数组
 * @description: 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 *
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 *
 */
public class LeetCode_43 {

    public static int[] shuffle(int[] nums, int n) {
        int[] ants = new int[nums.length];
        for (int i = 0;i < n; i++){
            ants[2 * i] = nums[i];
            ants[2 * i + 1] = nums[i + n];
        }
        return ants;
    }

    public static void main(String[] args) {
        int[] ants = {2,5,1,3,4,7};
        shuffle(ants,3);
    }
}
