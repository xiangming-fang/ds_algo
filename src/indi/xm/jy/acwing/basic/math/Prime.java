package indi.xm.jy.acwing.basic.math;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.basic.math
 * @ClassName: Prime
 * @Author: albert.fang
 * @Description: 质数、素数
 * @Date: 2022/11/18 16:14
 */
public class Prime {


    // 判断一个数是否是质数
    // true - 是
    public boolean isPrime(int x){
        if (x < 2) return false;
        for (int i = 2; i <= x/i; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isPrime(11));
    }


}
