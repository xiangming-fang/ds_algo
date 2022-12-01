package indi.xm.ds_algo.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.TreeMap;

public class SN0509 {

    public int fib(int n) {
        if (n == 0 || n == 1){
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        int pre,pre_pre,cur = 0;
        for (int i = 2; i <= n; i++) {
            pre = dp[1];
            pre_pre = dp[0];
            cur = pre + pre_pre;
            dp[0] = pre;
            dp[1] = cur;
        }
        return cur;
    }

    // 动态规划
    public int fib03(int n) {
        int[] dp = new int[n+2];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // 记忆递归
    public int fib02(int n) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        return fib(n, map);
    }

    private int fib(int n, TreeMap<Integer, Integer> map) {
        if (n == 0){
            map.put(n,0);
            return 0;
        }
        if (n == 1){
            map.put(n,1);
            return 1;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        map.put(n,fib(n-1,map) + fib(n-2,map));
        return map.get(n);
    }

    // 暴力递归
    public int fib01(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    @Test
    public void test(){
        System.out.println(fib(1));
    }
}
