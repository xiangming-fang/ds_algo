package indi.xm.jy.leetcode.sn.SN0600;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0539
 * @Author: albert.fang
 * @Description: 539. 最小时间差
 * @Date: 2022/1/18 18:11
 */
public class SN0539 {
    public int findMinDifference(List<String> timePoints) {

        int[] ans = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] aa = timePoints.get(i).split(":");
            String hourA = aa[0];
            String minuteA = aa[1];
            ans[i] = Integer.parseInt(hourA) * 60 + Integer.parseInt(minuteA);
        }

        Arrays.sort(ans);

        int res = Integer.MAX_VALUE;
        int pre = ans[0];

        for (int i = 1; i < ans.length; i++) {
            int diff = ans[i] - pre;
            res = Math.min(diff,res);
            if (diff == 0) return 0;
            pre = ans[i];
        }

        int endFront = Math.abs(ans[0] - ans[ans.length - 1]);

        res = Math.min(res,endFront);

        res = Math.min(24 * 60 - endFront,res);

        return res;
    }

}
