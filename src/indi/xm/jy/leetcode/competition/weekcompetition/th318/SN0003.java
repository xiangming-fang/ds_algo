package indi.xm.jy.leetcode.competition.weekcompetition.th318;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:26
 */
public class SN0003 {

    // 暴力？？？
    // tle
    public long totalCost(int[] costs, int k, int candidates) {
        long ans =  0;
        List<Integer> cost = new ArrayList<>();
        for (Integer c : costs) {
            cost.add(c);
        }
        for (int i = 0; i < k; i++) {
            int minC = Integer.MAX_VALUE,minI = Integer.MAX_VALUE;
            int len = Math.min(candidates, cost.size());
            for (int pre = 0; pre < len; pre++) {
                if (cost.get(pre) < minC) {
                    minC = cost.get(pre);
                    minI = pre;
                }
                if (cost.get(pre) == minC) minI = Math.min(minI,pre);
            }
            for (int last = cost.size() - len; last < cost.size(); last ++){
                if (cost.get(last) < minC) {
                    minC = cost.get(last);
                    minI = last;
                }
                if (cost.get(last) == minC) minI = Math.min(minI,last);
            }
            cost.remove(minI);
            ans += minC;
        }
        return ans;
    }



}
