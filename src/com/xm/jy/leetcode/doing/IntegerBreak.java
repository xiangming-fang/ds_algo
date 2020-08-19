package com.xm.jy.leetcode.doing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2020/7/30 15:06
 * @description: 343. 整数拆分
 * @description: 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 注意：是至少两个
 */
public class IntegerBreak {
    public static int integerBreak(int n) {
        int left = 1;
        int right = n - 1;
        List<Integer> list = new ArrayList<>();
        while (left <= right){
            list.add(left * right);
            left ++;
            right --;
        }
        int max = -1;
        for (Integer compare : list) {
            max = compare > max ? compare : max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(5));
    }
}
