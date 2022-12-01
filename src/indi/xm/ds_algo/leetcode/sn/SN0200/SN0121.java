package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0121
 * @Author: albert.fang
 * @Description: 买卖股票的最佳时机
 * @Date: 2021/8/26 13:39
 */
public class SN0121 {
    // 动态规划
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int dpMax = -1;
        int priceMin = Integer.MAX_VALUE;
        int maxProfit = dp[0];
        for (int i = 1; i < prices.length; i++) {
//            dp[i] = Math.max(getMax(0,i-1,dp),prices[i] - getMin(0,i-1,prices));
            dpMax = Math.max(dpMax,dp[i-1]);
            priceMin = Math.min(priceMin,prices[i-1]);
            dp[i] = Math.max(dpMax,prices[i] - priceMin);
            maxProfit = Math.max(maxProfit,dp[i]);
        }
        return maxProfit;
    }

    // 返回array从start开始到end范围的最大值
    private int getMax(int start,int end,int[] array){
        int max = -1;
        for (int i = start; i <= end; i++) {
            max = Math.max(array[i],max);
        }
        return max;
    }

    // 返回array从start开始到end范围的最小值
    private int getMin(int start,int end,int[] array){
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(array[i],min);
        }
        return min;
    }

    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{7,6,15,3,1}));
    }
}
