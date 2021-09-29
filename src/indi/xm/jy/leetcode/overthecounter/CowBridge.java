package indi.xm.jy.leetcode.overthecounter;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.overthecounter
 * @ClassName: CowBridge
 * @Author: albert.fang
 * @Description: 牛牛过桥
 * @Date: 2021/9/29 14:20
 */
public class CowBridge {
    public int goThroughBridge(int[] cows){
        Arrays.sort(cows);
        int res = 0;
        for (int i = cows.length - 1; i > 0; i--) {
            res += Math.min(cows[i],cows[i - 1]);
            cows[i-1] = Math.abs(cows[i] - cows[i-1]);
            cows[i] = 0;
        }
        // 加上首位
        res += cows[0];
        return res;
    }

    @Test
    public void test(){
        System.out.println(goThroughBridge(new int[]{2, 4, 6, 8}));
        System.out.println(goThroughBridge(new int[]{1, 4, 6, 8}));
        System.out.println(goThroughBridge(new int[]{1, 2, 4, 6, 8}));
    }
}
