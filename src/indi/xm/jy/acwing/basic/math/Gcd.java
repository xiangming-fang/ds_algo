package indi.xm.jy.acwing.basic.math;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.basic.math
 * @ClassName: Gcd
 * @Author: albert.fang
 * @Description: 最大公约数
 * @Date: 2022/11/18 17:09
 */
public class Gcd {


    public int gcd(int x,int y){
        return x % y == 0 ? y : gcd(x % y,y);
    }

    @Test
    public void test(){
        System.out.println(gcd(12, 6));
    }


}
