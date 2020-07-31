package com.xm.jy.leetcode.finished.array;

/**
 * @author: albert.fang
 * @date: 2020/7/21 11:00
 * @description: LCP 01. 猜数字
 */
public class LeetCode_7 {
    private static int game(int[] guess, int[] answer){
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]){
                count ++;
            }
        }
        return count;
    }
}
