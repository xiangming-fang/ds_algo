package indi.xm.ds_algo.leetcode.sn.SN0200;

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
