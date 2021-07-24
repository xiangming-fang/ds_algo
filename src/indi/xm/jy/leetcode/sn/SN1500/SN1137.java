package indi.xm.jy.leetcode.sn.SN1500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: albert.fang
 * @date: 2020/8/31 17:53
 * @description: 1137.第 N 个泰波纳契数 泰波那契序列 Tn 定义如下： 
 *
 */
public class SN1137 {

    private Map<Object,Integer> remMap = new HashMap<>();


    public int tribonacci(int n){
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
}
