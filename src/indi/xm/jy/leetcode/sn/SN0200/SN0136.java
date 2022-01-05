package indi.xm.jy.leetcode.sn.SN0200;

import java.util.Arrays;

/**
 * 只出现一次的数字
 */
public class SN0136 {
    public int singleNumber01(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    /**********************2022-01-05***********************/

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
