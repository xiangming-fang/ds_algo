package indi.xm.ds_algo.leetcode.sn.SN0400;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0322
 * @Author: albert.fang
 * @Description: 零钱兑换
 * @Date: 2021/8/25 10:31
 */
public class SN0322 {
    int res = Integer.MAX_VALUE;
    public int coinChange01(int[] coins, int amount) {
        coinChange(coins,amount);
        return res == Integer.MAX_VALUE  ? -1 : res;
    }
    private void coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res,1);
        }
        for (int coin : coins) {
            coinChange(coins, amount - coin);
            if (res == -1) {
                continue;
            }

        }
    }

    @Test
    public void test(){
        System.out.println(coinChange01(new int[]{3,2,5}, 11));
    }
}
