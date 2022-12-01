package indi.xm.ds_algo.leetcode.sn.SN0400;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0292
 * @Author: albert.fang
 * @Description: Nim 游戏
 * @Date: 2021/9/2 9:46
 */
public class SN0292 {
    public boolean canWinNim(int n) {
        return n%4 !=0;
    }

    @Test
    public void test(){
        for (int i = 1; i < 60; i++) {
            System.out.println(i + "   " + canWinNim(i));
        }
    }
}
