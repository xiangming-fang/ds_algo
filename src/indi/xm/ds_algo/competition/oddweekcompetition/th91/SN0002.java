package indi.xm.ds_algo.competition.oddweekcompetition.th91;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 统计构造好字符串的方案数
 * @Date: 2022/10/21 16:26
 */
public class SN0002 {

    // 思路：类比跳台阶问题
    // https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
    // 可以看成青蛙每次只能条zero个台阶或者one个台阶
    // dp[i]: 从0位置跳到i位置有几种跳法
    // dp[0] = 1
    // dp[i] = dp[i-one] + dp[i-zero]
    // 1、如果 i - one 并且 i - zero 都小于0，dp[i] = 0;
    // 2、如果只有 i - one 小于0，dp[i] = dp[i-zero];
    // 3、如果只有 i - zero 小于0，dp[i] = dp[i-one];
    // 4、如果都大于0,则 dp[i] = dp[i-zero] + dp[i-one];
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1000000007;
        int ans = 0;
        int[] dp = new int[high+1];
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i - zero < 0 && i - one < 0) dp[i] = 0;
            else if (i - zero < 0) dp[i] = dp[i - one] % mod;
            else if (i - one < 0) dp[i] = dp[i - zero] % mod;
            else dp[i] = (dp[i - one] + dp[i -zero]) % mod;
            if (i >= low) ans = (ans + dp[i]) % mod;
        }
        return ans;
    }

    @Test
    public void test(){
//        System.out.println(countGoodStrings(5, 5, 2, 4));
        System.out.println(countGoodStrings(10, 10, 10, 2));
    }



}
