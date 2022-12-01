package indi.xm.ds_algo.leetcode.sn.SN1000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0746
 * @Author: albert.fang
 * @Description: 使用最小花费爬楼梯
 * @Date: 2021/8/25 15:58
 */
public class SN0746 {

    // 动态规划
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1){
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1],dp[i - 2]);
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }

    @Test
    public void test(){
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs(new int[]{1,3}));
    }
}
