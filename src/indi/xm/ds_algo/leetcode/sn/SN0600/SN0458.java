package indi.xm.ds_algo.leetcode.sn.SN0600;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0458
 * @Author: albert.fang
 * @Description: 可怜的小猪
 * @Date: 2021/11/25 14:48
 */
public class SN0458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        int pigs = (int) Math.ceil(Math.log(buckets) / Math.log(states));
        return pigs;
    }

    @Test
    public void test(){
        System.out.println(Math.log(123.12));
    }
}
