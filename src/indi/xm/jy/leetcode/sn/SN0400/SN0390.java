package indi.xm.jy.leetcode.sn.SN0400;

import java.util.ArrayList;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0390
 * @Author: albert.fang
 * @Description: 消除游戏
 * @Date: 2022/1/2 18:13
 */
public class SN0390 {

    public int lastRemaining(int n){
        int head = 1;
        boolean left = true;
        int step = 1;
        while (n > 1){
            if (left || ((n & 1) != 0)){
                head += step;
            }
            step <<= 1;
            n >>= 1;
            left = !left;
        }
        return head;
    }
}
