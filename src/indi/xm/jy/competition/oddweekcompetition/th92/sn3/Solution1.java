package indi.xm.jy.competition.oddweekcompetition.th92.sn3;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.competition.oddweekcompetition.th92.sn3
 * @ClassName: Solution1
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/11/26 23:31
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
