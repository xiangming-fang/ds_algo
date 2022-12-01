package indi.xm.ds_algo.leetcode.sn.SN0600;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0598
 * @Author: albert.fang
 * @Description: 范围求和 II
 * @Date: 2021/11/7 10:39
 */
public class SN0598 {
    public int maxCount(int m, int n, int[][] ops) {
        int minA = m,minB = n;
        for (int[] op : ops) {
            minA = Math.min(minA, op[0]);
            minB = Math.min(minB, op[1]);
        }
        return minA * minB;
    }

    @Test
    public void test(){
        System.out.println(maxCount(3, 3, new int[][]{}));
    }
}
