package com.xm.jy.leetcode.sn.SN2000;

/**
 * @author: albert.fang
 * @date: 2020/7/21 11:40
 * @description: 1512. 好数对的数目
 */
public class SN1512 {
    private static int numIdenticalPairs(int[] nums){
        int countPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    countPairs++;
                }
            }
        }
        return countPairs;
    }
}
