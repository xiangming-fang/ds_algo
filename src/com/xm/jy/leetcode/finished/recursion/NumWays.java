package com.xm.jy.leetcode.finished.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: albert.fang
 * @date: 2020/8/31 18:14
 * @description: 青蛙跳台问题：青蛙跳上n级台阶，有几种跳法，每次跳一级，或2级。要取模
 */
public class NumWays {

    private static Map<Object,Integer> remMap = new HashMap<>();

    public static int numWays(int n){
        if ( n == 0){
            return 1;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (!remMap.containsKey(n)){
            remMap.put(n,(numWays(n-1)+numWays(n-2)) % 1000000007);
        }
        return remMap.get(n);
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
