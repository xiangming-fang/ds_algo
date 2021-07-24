package indi.xm.jy.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: albert.fang
 * @date: 2020/8/31 17:34
 * @description: 剑指 Offer 10- I. 斐波那契数列第n项，答案还要对 1000000007 取模
 */
public class Offer10_1 {
    private static Map<Object,Integer> rememberMap = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(fib(45));
    }

    public static int  fib(int n ){
        if (n < 2){
            return n;
        }
        if (!rememberMap.containsKey(n)){
            rememberMap.put(n,(fib(n - 1 ) + fib( n - 2 )) % 1000000007);
        }
        return rememberMap.get(n);
    }
}
