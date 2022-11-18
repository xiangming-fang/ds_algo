package indi.xm.jy.acwing.basic.math;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.basic.math
 * @ClassName: Lcm
 * @Author: albert.fang
 * @Description: 最小公倍数
 * @Date: 2022/11/18 17:12
 */
public class Lcm {


    public int lcm(int x,int y){
        return x * y / gcd(x,y);
    }

    public int gcd(int x,int y){
        return x % y == 0 ? y : gcd(x % y,y);
    }

    @Test
    public void test(){
        System.out.println(lcm(12, 3));
    }


}
