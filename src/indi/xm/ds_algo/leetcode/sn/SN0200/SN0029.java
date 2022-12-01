package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0029
 * @Author: albert.fang
 * @Description: 两数相除
 * @Date: 2021/9/10 15:03
 */
public class SN0029 {
    public int divide(int dividend, int divisor) {
        return dividend >> divisor;
    }

    @Test
    public void test(){
        System.out.println(divide(10, 1));
        System.out.println(divide(10, 2));
        System.out.println(divide(10, 3));
        System.out.println(divide(10, 4));
        System.out.println(divide(10, 5));
        System.out.println(divide(10, -1));
        System.out.println(divide(10, -2));
        System.out.println(10);
        System.out.println(10 >> 30);
        System.out.println((long) 1 << 31);
        System.out.println( Math.pow(2,31) - 1);
        System.out.println( Integer.MAX_VALUE);
        System.out.println( Integer.MAX_VALUE == Math.pow(2,31) - 1);
        System.out.println( Integer.MIN_VALUE );
        System.out.println((-1 ^ 3) < 0 );
        System.out.println((-1 ^ -3) < 0 );
        System.out.println((1 ^ 3) < 0 );
    }
}
