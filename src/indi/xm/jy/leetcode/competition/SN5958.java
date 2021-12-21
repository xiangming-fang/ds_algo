package indi.xm.jy.leetcode.competition;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition
 * @ClassName: SN5957
 * @Author: albert.fang
 * @Description: 5958. 股票平滑下跌阶段的数目
 * @Date: 2021/12/20 9:41
 */
public class SN5958 {
    // 超时做法
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        int pre,cur;
        for (int i = 0; i < prices.length; i++) {
            res ++;
            pre = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                cur = prices[j];
                if (pre - cur == 1){
                    res ++;
                    pre = cur;
                    continue;
                }
                break;
            }
        }
        return res;
    }
}
