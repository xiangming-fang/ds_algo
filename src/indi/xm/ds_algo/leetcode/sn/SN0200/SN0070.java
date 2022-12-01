package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0070
 * @Author: albert.fang
 * @Description: 爬楼梯
 * @Date: 2021/8/25 15:04
 */
public class SN0070 {

    // 动态规划，状态压缩
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int one = 1,two = 2,cur=0;
        for (int i = 3; i <= n; i++) {
            cur = one + two;
            one = two;
            two = cur;
        }
        return cur;
    }

    // 暴力递归
    public int climbStairs01(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return climbStairs01(n-1) + climbStairs01(n-2);
    }

    @Test
    public void test(){
        System.out.println(climbStairs01(30));
        System.out.println(climbStairs(30));
    }
}
