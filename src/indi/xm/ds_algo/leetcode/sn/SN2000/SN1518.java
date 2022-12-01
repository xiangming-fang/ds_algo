package indi.xm.ds_algo.leetcode.sn.SN2000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1518
 * @Author: albert.fang
 * @Description: 1518. 换酒问题
 * @Date: 2021/12/17 9:49
 */
public class SN1518 {

    // 模拟题
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles / numExchange > 0) {
            res += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(numWaterBottles(15, 4));
    }

}
