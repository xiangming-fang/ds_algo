package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0069
 * @Author: albert.fang
 * @Description: x的平方根
 * @Date: 2022/10/26 13:00
 */
public class SN0069 {


    public double mySqrt(int x) {
        double l = 0,r = Integer.MAX_VALUE;
        while (r - l > 1e-8){
            double mid = l + (r-l)/2;
            if (mid * mid >= x) r = mid;
            else l = mid;
        }
        return r;
    }

    @Test
    public void test(){
        System.out.println(mySqrt(2147395599));
        System.out.println(Math.sqrt(2147395599));
    }


}
