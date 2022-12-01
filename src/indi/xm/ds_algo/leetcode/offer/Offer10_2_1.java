package indi.xm.ds_algo.leetcode.offer;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.offer
 * @ClassName: Offer10_2_1
 * @Author: albert.fang
 * @Description: 青蛙跳台
 * @Date: 2022/11/14 14:44
 */
public class Offer10_2_1 {

    int mod = 1000000007;

    public int numWays(int n){
        if ( n < 2) return 1;
        // dp[i] 含义：表示到第i个台阶有几种跳法
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(numWays(92));
    }
}
