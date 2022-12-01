package indi.xm.ds_algo.competition.oddweekcompetition.th92.sn3;

import org.junit.Test;

/**
 * t3 商店的最少代价
 * 算法原型：前缀和、后缀和
 * 思路：
 * 1、没关店前，统计N出现的个数，构造前缀数组
 * 2、关店后，统计Y出现的个数，构造后缀数组
 * 3、遍历每个位置，得到最小代价关店时机
 */
public class Solution1 {

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] pre = new int[n + 1];
        int[] suffix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (customers.charAt(i-1) == 'N') pre[i] = pre[i-1] + 1;
            else pre[i] = pre[i-1];
        }
        for (int i = n-1; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') suffix[i] = suffix[i+1] + 1;
            else suffix[i] = suffix[i+1];
        }
        int minCost = Integer.MAX_VALUE,ans = 0;
        for (int i = 0; i <= n; i++) {
            int tmp = pre[i] + suffix[i];
            if (tmp < minCost) {
                minCost = tmp;
                ans = i;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(bestClosingTime("YYYY"));
    }

}
