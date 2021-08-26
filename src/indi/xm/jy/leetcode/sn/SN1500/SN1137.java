package indi.xm.jy.leetcode.sn.SN1500;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: albert.fang
 * @date: 2020/8/31 17:53
 * @description: 1137.第 N 个泰波纳契数 泰波那契序列 Tn 
 *
 */
public class SN1137 {

    private Map<Object,Integer> remMap = new HashMap<>();

    public int tribonacci02(int n){
        if (n == 0 || n == 1){
            return n;
        }
        if (n == 2){
            return 1;
        }
        int one = 0,two = 1,three = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = one + two + three;
            one = two;
            two = three;
            three = sum;
        }
        return sum;
    }

    // 记忆递归
    public int tribonacci01(int n){
        return tribonacci(n);
    }

    private int tribonacci(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        if (!remMap.containsKey(n)){
            remMap.put(n,tribonacci(n - 1 ) + tribonacci( n - 2 ) + tribonacci( n - 3 ));
        }
        return remMap.get(n);
    }

    @Test
    public void test(){
        System.out.println(tribonacci02(0));
        System.out.println(tribonacci02(1));
        System.out.println(tribonacci02(2));
        System.out.println(tribonacci02(3));
        System.out.println(tribonacci02(4));
        System.out.println(tribonacci02(5));
    }
}
