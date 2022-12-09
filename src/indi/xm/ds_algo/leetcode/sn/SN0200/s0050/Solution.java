package indi.xm.ds_algo.leetcode.sn.SN0200.s0050;

import org.junit.Test;

/**
 * 实现pow(x,n)函数
 *
 */
public class Solution {

    // tle了
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        boolean flag = n > 0;
        if (n < 0) n = -n;
        double ans = 1;
        while (n -- > 0) ans *= x;
        return flag? ans : 1/ans;
    }

    @Test
    public void test(){
        System.out.println(myPow(2.1, 3));
        System.out.println(Math.pow(2.1, 3));
    }

}
