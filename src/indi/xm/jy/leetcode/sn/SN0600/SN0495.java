package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0495
 * @Author: albert.fang
 * @Description: 提莫攻击
 * @Date: 2021/11/10 14:13
 */
public class SN0495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = duration;
        int len = timeSeries.length;
        for (int i = len - 2; i >= 0 ; i--) {
            res += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(findPoisonedDuration(new int[]{1, 2,3,4,5,6}, 2));
        System.out.println(findPoisonedDuration(new int[]{1, 2,3,4,5,6}, 3));
    }
}
