package indi.xm.ds_algo.leetcode.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.test
 * @ClassName: TestTemplate
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/8/25 11:43
 */
public class TestTemplate {
    @Test
    public void test(){
        System.out.println(1 & 1);
        System.out.println(3 & 1);
        System.out.println(mul(3, 9));
        System.out.println(1 >> 1);
        System.out.println(7 << 0);
        ArrayList<Integer> res = new ArrayList<>();
        binaryShow(23,res);
//        System.out.println(res);
    }

    private long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) ans += a;
            k = k >> 1;
            a += a;
        }
        return ans;
    }

    private long myMul(long a, long b){
        return 1;
    }

    /**
     * 将一个数表示成 2的n次方形式
     * eg：8 = 2^3
     * eg：9 = 2^3 + 2^0
     * eg: 21 = 2^4 + 2^2 + 2^0
     * @param num
     * @param res 返回的是所有2的指数集合
     */
    private void binaryShow(long num,List<Integer> res){
        if ((num >> 1) == 0 ){
            res.add(0);
            return;
        }
        int single = 0;
        while (num > 0){
            single ++;
            num = num - (num >> 1);
        }
        res.add(single);
    }
}
