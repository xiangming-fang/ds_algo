package indi.xm.ds_algo.leetcode.sn.SN0400.s0342;

/**
 * @Author: albert.fang
 * @Description: 4的幂
 * @Date: 2022/12/9 16:47
 */
public class Solution {

    // 短除法，通吃
    public boolean isPowerOfFour(int n) {
        int ans = 0;
        if (n < 0) return false;
        while (n != 0){
            if (n%4 == 2 || n % 4 == 3) return false;
            if (n%4 == 1) ans ++;
            n /= 4;
        }
        return ans == 1;
    }


}
