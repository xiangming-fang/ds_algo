package com.xm.jy.leetcode.finished.array;

/**
 * @author: albert.fang
 * @date: 2020/7/21 11:05
 * @description: 1480. 一维数组的动态和
 */
public class LeetCode_8 {
    public static void main(String[] args) {
        for (int i : runningSum(new int[]{1, 2, 3})) {
            System.out.println(i);
        }
    }
    private static int[] runningSum(int[] nums) {
        int[] target = new int[nums.length];
        target[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            target[i] = target[i - 1] + nums[i];
        }
        return target;
    }
}
