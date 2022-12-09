package indi.xm.ds_algo.leetcode.sn.SN2000.s1780_2;

/**
 * @Author: albert.fang
 * @Description: 判断是否为3的幂和
 * @Date: 2022/12/9 16:39
 */
public class Solution {

    // 用短除法，将n转成3进制，在转换的过程中判断是否会出现2，会的话，直接就不可以
    public boolean checkPowersOfThree(int n) {
        while ( n != 0 ){
            if (n%3 == 2) return false;
            n /= 3;
        }
        return true;
    }

}
